package com.donghyeon.springJpa.advancedmapping;

import com.donghyeon.springJpa.BaseAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Item{
    @EmbeddedId
    private ItemId id;

    private String name;
    private int price;
}


