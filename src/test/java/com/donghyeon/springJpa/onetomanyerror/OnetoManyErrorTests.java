package com.donghyeon.springJpa.onetomanyerror;

import com.donghyeon.springJpa.repo.BoardRepository;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OnetoManyErrorTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void test() {
        //https://velog.io/@dpudpu/5
        System.out.println("save 1 Board and 2 Image Start");
        Board board = new Board("test Board");
        board.imageList.add(new Image("file://aaa.png"));
        board.imageList.add(new Image("file://bbb.png"));
        board = boardRepository.save(board);
        System.out.println("save 1 Board and 2 Image End");

        System.out.println("Add one Image");
        board.imageList.add(new Image("file://ccc.png"));
        boardRepository.save(board);
        System.out.println("Add one Image End");

    }
}
