package com.donghyeon.springJpa.onetomanyerror;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BoardAndImage {

    @Id @Column(name = "BOARDANDIMAGE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IMAGE_ID")
    private Image image;

    public BoardAndImage(Board board, Image image) {
        this.board = board;
        this.image = image;
    }
}
