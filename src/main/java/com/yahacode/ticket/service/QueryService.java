package com.yahacode.ticket.service;

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
            String[] data = result.split("\\|");
            Detail detail = Detail.builder().trainNo(data[3]).startStation(QueryInvoker.map.get(data[6])).
                    destStation(QueryInvoker.map.get(data[7])).
                    startDate(data[8]).destDate(data[9]).duration(data[10]).businessClass(data[32]).
                    firstClass(data[31]).secondClass(data[30]).exclusiveSoftSleeper(data[21]).softSleeper(data[23]).
                    highSpeedSleeper(data[33]).hardSleeper(data[28]).softSeat(data[24]).
                    hardSeat(data[29]).noSeat(data[26]).other(data[22]).canWebBuy(data[11]).build();
            details.add(detail);
            String start = data[4].equals(data[6]) ? "始" : "过";
            String end = data[5].equals(data[7]) ? "终" : "过";
            //map.get(data[6]) + "，" + end + "：" + map.get(data[7])
        }
        return details;
    }
}
