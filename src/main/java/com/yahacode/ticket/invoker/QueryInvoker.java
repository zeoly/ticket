package com.yahacode.ticket.invoker;

import com.yahacode.ticket.common.UrlConsts;
import com.yahacode.ticket.model.CaptchaResponse;
import com.yahacode.ticket.model.PassengersQueryResponse;
import com.yahacode.ticket.model.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zengyongli 2019-09-11
 */
@Component
public class QueryInvoker {

    public static Map<String, String> map = new HashMap<>();

    @Autowired
    RestOperations restTemplate;

    public String queryStation(){
        String station = restTemplate.getForEntity(UrlConsts.STATION_NAME, String.class).getBody();
        return station;
    }

    public String[] queryLeft(String startStation, String destStation, String date) {
        String url = UrlConsts.LEFT_TICKET.replace("{DATE}", date).replace("{START}", startStation).replace("{DEST}",
                destStation);
        HttpEntity<String> requestEntity = new HttpEntity<>(getHeaders());
//        String a = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class).getBody();
//        String b = restTemplate.getForEntity(UrlConsts.LEFT_TICKET, String.class).getBody();
        QueryResponse response =
                restTemplate.exchange(url, HttpMethod.GET, requestEntity, QueryResponse.class).getBody();
        this.map = response.getData().getMap();
        return response.getData().getResult();
    }


    public void captchaTest() {
        CaptchaResponse response = restTemplate.getForEntity(UrlConsts.CAPTCHA, CaptchaResponse.class).getBody();
        System.out.println(response.getImage());
    }

    public void passengersQuery() {
        PassengersQueryResponse response = restTemplate.getForEntity(UrlConsts.PASSENGERS_QUERY,
                PassengersQueryResponse.class).getBody();
        System.out.println(response.toString());
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json;charset=UTF-8");
//        headers.add("Accept-Encoding", "gzip, deflate, br");
        headers.add("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/79.0.3945.88 Safari/537.36");
        headers.add("Host", "kyfw.12306.cn");
        headers.add("Connection", "keep-alive");
        headers.add("Upgrade-Insecure-Requests", "1");
        headers.add("Cookie", "JSESSIONID=AA40E4607481D911E76D804088449BF6; _jc_save_wfdc_flag=dc; " +
                "_jc_save_toStation=%u91CD%u5E86%2CCQW; _jc_save_fromStation=%u6DF1%u5733%2CSZQ; " +
                "BIGipServerotn=1306067210.50210.0000; RAIL_EXPIRATION=1578003705321; " +
                "RAIL_DEVICEID=qDw6JNG00zI-AOniRM-QYHaI5UJFhqAgPjGBcc0Dp-AdU4" +
                "-hNaw3DOAFOWzzEIndDrT7CmiI9s1J4nNkPVzoLvVD4vgGEgflrbCE6p1aDbUHymwSE4R4c64vTXRQwnnaU7ri6rTF_onWXF50qQvmaoAw4BZCRo_t; BIGipServerpassport=770179338.50215.0000; route=9036359bb8a8a461c164a04f8f50b252; _jc_save_fromDate=2020-01-31; _jc_save_toDate=2020-01-02");
        return headers;
    }
}
