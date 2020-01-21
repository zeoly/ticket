package com.yahacode.ticket.service;

import com.yahacode.ticket.common.SeatTypeConsts;
import com.yahacode.ticket.invoker.QueryInvoker;
import com.yahacode.ticket.model.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengyongli 2020-01-02
 */
@Component
public class QueryService {

    @Autowired
    private QueryInvoker queryInvoker;

    public List<Detail> queryDetail(String startStation, String destStation, String date) {
        String[] results = queryInvoker.queryLeft(startStation, destStation, date);
        List<Detail> details = new ArrayList<>();
        for (String result : results) {
            String[] data = result.split("\\|", -1);
            data = handleCandidate(data);
            Detail detail =
                    Detail.builder().startStation(QueryInvoker.map.get(data[6])).destStation(QueryInvoker.map.get(data[7])).startDate(data[8]).destDate(data[9]).duration(data[10]).businessClass(data[32]).
                    firstClass(data[31]).secondClass(data[30]).exclusiveSoftSleeper(data[21]).softSleeper(data[23]).
                    highSpeedSleeper(data[33]).hardSleeper(data[28]).softSeat(data[24]).
                    hardSeat(data[29]).noSeat(data[26]).other(data[22]).canWebBuy(data[11]).build();
            detail.setStationTrainCode(data[3]);
            detail.setTrainNo(data[2]);
            details.add(detail);
            String start = data[4].equals(data[6]) ? "始" : "过";
            String end = data[5].equals(data[7]) ? "终" : "过";
            //map.get(data[6]) + "，" + end + "：" + map.get(data[7])
        }
        return details;
    }

    private String[] handleCandidate(String[] data) {
        String candidateFlag = data[37];
        if ("1".equals(candidateFlag)) {
            String[] seatTypes = data[35].split("");
            for (String seatType : seatTypes) {
                String status = data[SeatTypeConsts.SEAT_TYPE_MAP.get(seatType)];
                if ("无".equals(status)) {
                    data[SeatTypeConsts.SEAT_TYPE_MAP.get(seatType)] = "候补";
                    if (data[38].contains(seatType)) {
                        data[SeatTypeConsts.SEAT_TYPE_MAP.get(seatType)] = "候补无";
                    }
                }
            }
        }
        for (String seat : SeatTypeConsts.SEAT_TYPE_MAP.keySet()) {
            if ("".equals(data[SeatTypeConsts.SEAT_TYPE_MAP.get(seat)])) {
                data[SeatTypeConsts.SEAT_TYPE_MAP.get(seat)] = "--";
            }
        }
        return data;
    }

    public void queryByTrainNo(String trainNo, String startStation, String destStation, String date) {
        queryInvoker.queryByTrainNo(trainNo, startStation, destStation, date);
    }
}
