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
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author zengyongli 2019-09-11
 */
@Component
public class QueryInvoker {

    @Autowired
    RestTemplate restTemplate;

    public void queryLeft() {
        HttpEntity<String> requestEntity = new HttpEntity<>(getHeaders());
        String a = restTemplate.exchange(UrlConsts.LEFT_TICKET, HttpMethod.GET, requestEntity, String.class).getBody();

        QueryResponse response = restTemplate.exchange(UrlConsts.LEFT_TICKET, HttpMethod.GET, requestEntity,
                QueryResponse.class).getBody();
        Map<String, String> map = response.getData().getMap();
        for (String str : response.getData().getResult()) {
            String[] data = str.split("\\|");
            String start = data[4].equals(data[6]) ? "始" : "过";
            String end = data[5].equals(data[7]) ? "终" : "过";
            String output =
                    "车次：" + data[3] + "，" + start + "：" + map.get(data[6]) + "，" + end + "：" + map.get(data[7]) +
                            "，出发：" + data[8] + "，到达：" + data[9] + "，历时：" + data[10] + "，商务座：" + data[32] + "，一等座：" + data[31] + "，二等座：" + data[30] + "，软卧：" + data[23] + "，硬卧：" + data[28] + "，硬座：" + data[29] + "，无座：" + data[26];
            System.out.println(output);
        }
        System.out.println(response.toString());
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
        headers.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8," +
                "application/signed-exchange;v=b3");
        headers.add("Accept-Encoding", "gzip, deflate, br");
        return headers;
    }
}
