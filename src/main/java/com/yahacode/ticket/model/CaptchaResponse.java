package com.yahacode.ticket.model;

import lombok.Data;

/**
 * @author zengyongli 2019-09-17
 */
@Data
public class CaptchaResponse {

    String image;

    String resultCode;

    String resultMessage;
}
