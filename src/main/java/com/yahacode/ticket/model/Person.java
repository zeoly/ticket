package com.yahacode.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author zengyongli 2020-01-02
 */
@Data
@Builder
@AllArgsConstructor
public class Person {

    private String firstName;

    private String lastName;

    private String email;
}
