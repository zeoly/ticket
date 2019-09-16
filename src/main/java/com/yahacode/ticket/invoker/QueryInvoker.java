package com.yahacode.ticket.invoker;

import com.yahacode.ticket.model.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author zengyongli 2019-09-11
 */
@Component
public class QueryInvoker {

    private final static String URL = "https://kyfw.12306.cn/otn/leftTicket/queryA?leftTicketDTO" + ".train_date=2019"
            + "-10-06&leftTicketDTO.from_station=CQW&leftTicketDTO.to_station=SZQ&purpose_codes=ADULT";

    @Autowired
    RestTemplate restTemplate;

    public void queryTest() {
        QueryResponse response = restTemplate.getForEntity(URL, QueryResponse.class).getBody();
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
}
