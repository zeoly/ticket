package com.yahacode.ticket.model;

import lombok.Data;

import java.util.Map;

/**
 * @author zengyongli 2019-09-11
 */
@Data
public class QueryResponse {

    Data data;

    Integer httpstatus;

    String messages;

    Boolean status;

    @lombok.Data
    public class Data {

        String flag;

        Map<String, String> map;

        String[] result;
    }
}
