package com.donghyeon.springJpa.advancedmapping;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemId implements Serializable {
    @Id
    @Column(name = "ITEM_ID")
    private Long id;
    @Id
    private String itemName;

    public ItemId() {
    }

    public ItemId(Long id, String itemName) {
        this.id = id;
        this.itemName = itemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemId itemId = (ItemId) o;
        return Objects.equals(id, itemId.id) &&
                Objects.equals(itemName, itemId.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName);
    }
}
