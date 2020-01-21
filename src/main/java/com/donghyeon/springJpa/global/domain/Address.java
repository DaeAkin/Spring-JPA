package com.donghyeon.springJpa.global.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String zipCode;
}
