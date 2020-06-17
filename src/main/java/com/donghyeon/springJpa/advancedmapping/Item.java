package com.donghyeon.springJpa.advancedmapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    protected String name;
    protected int price;
}


@Entity
@NoArgsConstructor
class Album extends Item {

    private String artist;

    public Album(String name, int price, String artist) {
        this.name = name;
        this.price = price;
        this.artist = artist;
    }
}

@Entity
class Computer extends Item {

    private String maker;

    public Computer(String name, int price, String maker) {
        this.name = name;
        this.price = price;
        this.maker = maker;
    }
}
@Entity
class Food extends Item {

    private int calory;

    public Food(String name, int price, int calory) {
        this.name = name;
        this.price = price;
        this.calory = calory;
    }
}


