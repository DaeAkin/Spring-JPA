package com.donghyeon.springJpa.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "city")
    private String city;
    private String street;
    private String zipcode;
}
