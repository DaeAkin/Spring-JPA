package com.donghyeon.springJpa.onetomanyerror;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="BOARD_IMAGE",
            joinColumns = @JoinColumn(name = "BOARD_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
     List<Image> imageList = new ArrayList<>();

    public Board(String title) {
        this.title = title;
    }
}
