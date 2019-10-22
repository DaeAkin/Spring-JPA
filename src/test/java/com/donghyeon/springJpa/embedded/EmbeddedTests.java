package com.donghyeon.springJpa.embedded;

import com.donghyeon.springJpa.TestConfiguration;
import com.donghyeon.springJpa.manytomany.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class EmbeddedTests {


    @Test
    public void manyToManyTests() {
        System.out.println("hi");


    }
}
