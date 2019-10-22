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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    private String title;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "board")
    List<BoardAndImage> boardAndImageList = new ArrayList<>();

    public Board(String title) {
        this.title = title;
    }
}
