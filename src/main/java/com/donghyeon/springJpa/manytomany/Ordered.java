package com.donghyeon.springJpa.manytomany;

import com.donghyeon.springJpa.global.domain.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ordered {

    @Id @Column(name = "ORDERED_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    //추가필드
    private long orderMount;

}
