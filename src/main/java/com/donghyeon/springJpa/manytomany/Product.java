package com.donghyeon.springJpa.manytomany;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
//애는 양방향으로 안이어줌
public class Product {

    @Id @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Product(String name) {
        this.name = name;
    }

    //역방향 추가 (양방향)
    @OneToMany(mappedBy = "product")
    private List<Ordered> orderedList = new ArrayList<>();

}
