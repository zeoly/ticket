package com.yahacode.ticket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zengyongli 2019-09-11
 */
@Configuration
public class RestConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
