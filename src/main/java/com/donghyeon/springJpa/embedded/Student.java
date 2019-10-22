package com.donghyeon.springJpa.embedded;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @Embedded Period workPeriod; // 근무 기간
    @Embedded Address homeAddress; // 집 주소


}
