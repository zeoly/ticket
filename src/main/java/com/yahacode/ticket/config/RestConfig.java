//package com.yahacode.ticket.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author zengyongli 2019-09-11
// */
//@Configuration
//public class RestConfig {
//
////    @Bean
////    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
////        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
////        factory.setConnectTimeout(15000);
////        factory.setReadTimeout(10000);
////        return factory;
////    }
//
//    @Bean
//    RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
////        restTemplate.getMessageConverters().add(new MyMappingJackson2HttpMessageConverter());
//        return restTemplate;
//    }
//
//    public class MyMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
//        public MyMappingJackson2HttpMessageConverter() {
//            List<MediaType> mediaTypes = new ArrayList<>();
//            mediaTypes.add(MediaType.TEXT_HTML);
//            setSupportedMediaTypes(mediaTypes);
//        }
//    }
//}
