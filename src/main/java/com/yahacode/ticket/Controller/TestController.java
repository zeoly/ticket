//package com.yahacode.ticket.Controller;
//
//import com.yahacode.ticket.invoker.QueryInvoker;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author zengyongli 2019-09-11
// */
//@RestController
//public class TestController {
//
//    @Autowired
//    QueryInvoker queryInvoker;
//
//    @GetMapping("/query")
//    public void query() {
//        queryInvoker.queryLeft();
//    }
//
//    @GetMapping("/captcha")
//    public void captcha() {
//        queryInvoker.captchaTest();
//    }
//
//    @GetMapping("/passengers")
//    public void passengersQuery() {
//        queryInvoker.passengersQuery();
//    }
//}
