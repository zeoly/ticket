package com.yahacode.ticket.common;

/**
 * @author zengyongli 2019-09-18
 */
public class UrlConsts {

    public static final String LEFT_TICKET = "https://kyfw.12306.cn/otn/leftTicket/queryZ?leftTicketDTO.train_date={DATE}&leftTicketDTO.from_station=SZQ&leftTicketDTO.to_station=CQW&purpose_codes=ADULT";

    public static final String CAPTCHA = "https://kyfw.12306.cn/passport/captcha/captcha-image64?login_site=E" +
            "&module=login&rand=sjrand";

    public static final String PASSENGERS_QUERY = "https://kyfw.12306.cn/otn/passengers/query";

}
