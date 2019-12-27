package com.yahacode.ticket.model;

//import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author zengyongli 2019-09-17
 */
@Data
public class PassengersQueryResponse {

    Result data;

    Integer httpstatus;

    Boolean status;

    @Data
    class Result{

        Passenger[] datas;

        Boolean flag;

        Integer pageTotal;
    }

    @Data
    class Passenger {

//        @JsonProperty(value = "passenger_name")
        String passengerName;

//        @JsonProperty(value = "passenger_id_type_name")
        String passengerIdTypeName;

//        @JsonProperty(value = "passenger_id_no")
        String passengerIdNo;

//        @JsonProperty(value = "mobile_no")
        String mobileNo;

        String isAdult;
    }
}
