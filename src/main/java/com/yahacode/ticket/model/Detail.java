package com.yahacode.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author zengyongli 2020-01-02
 */
@Data
@Builder
@AllArgsConstructor
public class Detail {

    private String trainNo;

    private String stationTrainCode;

    private String startStation;

    private String destStation;

    private String startDate;

    private String destDate;

    private String duration;

    private String businessClass;

    private String firstClass;

    private String secondClass;

    private String exclusiveSoftSleeper;

    private String softSleeper;

    private String highSpeedSleeper;

    private String hardSleeper;

    private String softSeat;

    private String hardSeat;

    private String noSeat;

    private String other;

    private String candidateFlag;

    private String candidateSeatLimit;

    private String canWebBuy;
}
