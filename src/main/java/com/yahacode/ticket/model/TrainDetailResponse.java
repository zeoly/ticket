package com.yahacode.ticket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class TrainDetailResponse {

    Result data;

    Integer httpstatus;

    String[] messages;

    Boolean status;

    @Data
    public class Result {

        TrainDetail[] data;
    }

    @Data
    @AllArgsConstructor
    public static class TrainDetail {

        @JsonProperty("station_no")
        String stationNo;

        @JsonProperty("station_name")
        String stationName;

        @JsonProperty("arrive_time")
        String arriveTime;

        @JsonProperty("start_time")
        String startTime;

        @JsonProperty("stopover_time")
        String stopoverTime;

        boolean inEnabled;
    }
}
