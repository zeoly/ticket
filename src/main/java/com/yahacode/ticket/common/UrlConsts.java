package com.yahacode.ticket.common;

/**
 * @author zengyongli 2019-09-18
 */
public class UrlConsts {

    public static final String STATION_NAME = "https://kyfw.12306.cn/otn/resources/js/framework/station_name.js";

    public static final String LEFT_TICKET = "https://kyfw.12306.cn/otn/leftTicket/queryZ?leftTicketDTO" +
            ".train_date={DATE}&leftTicketDTO.from_station={START}&leftTicketDTO.to_station={DEST}&purpose_codes=ADULT";

    public static final String TRAIN_DETAIL = "https://kyfw.12306.cn/otn/czxx/queryByTrainNo?train_no={TRAIN_NO}" +
            "&from_station_telecode={START}&to_station_telecode={DEST}&depart_date={DATE}";

    public static final String CAPTCHA = "https://kyfw.12306.cn/passport/captcha/captcha-image64?login_site=E" +
            "&module=login&rand=sjrand";

    public static final String PASSENGERS_QUERY = "https://kyfw.12306.cn/otn/passengers/query";

}
