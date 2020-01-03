package com.yahacode.ticket.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zengyongli 2020-01-03
 */
public class SeatTypeConsts {

    public static final Map<String, Integer> SEAT_TYPE_MAP = new HashMap<>();

    static {
        /*商务座*/
        SEAT_TYPE_MAP.put("9", 32);
        /*一等座*/
        SEAT_TYPE_MAP.put("M", 31);
        /*二等座*/
        SEAT_TYPE_MAP.put("O", 30);
        /*高级动卧*/
        SEAT_TYPE_MAP.put("6", 21);
        /*软卧*/
        SEAT_TYPE_MAP.put("4", 23);
        /*动卧*/
        SEAT_TYPE_MAP.put("F", 33);
        /*硬卧*/
        SEAT_TYPE_MAP.put("3", 28);
        /*软座*/
        SEAT_TYPE_MAP.put("2", 24);
        /*硬座*/
        SEAT_TYPE_MAP.put("1", 29);
        /*无座*/
        SEAT_TYPE_MAP.put("WZ", 26);
        /*其他*/
        SEAT_TYPE_MAP.put("H", 22);
    }
}
