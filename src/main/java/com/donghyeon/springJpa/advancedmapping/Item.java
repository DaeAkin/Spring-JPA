package com.donghyeon.springJpa.advancedmapping;

import com.donghyeon.springJpa.BaseAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AttributeOverride(name = "createdTime" ,column = @Column(name="makeTime"))
public class Item extends BaseAuditingEntity {
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
        this.createdTime = LocalDateTime.now();
    }
    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
}



