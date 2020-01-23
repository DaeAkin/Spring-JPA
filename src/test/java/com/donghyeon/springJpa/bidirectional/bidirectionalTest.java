package com.donghyeon.springJpa.bidirectional;

import com.donghyeon.springJpa.TestConfiguration;
import com.donghyeon.springJpa.global.domain.Human;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * 양방향 관계 테스트 소스
 * @See https://github.com/DaeAkin/Spring-Jpa/blob/master/docs/JPA%20%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84%20%EB%A7%A4%ED%95%91.md
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class bidirectionalTest {

    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;
    @Before
    public void setUp() {
        em = emf.createEntityManager(); // Retrieve an application managed entity manager
    }

    @Test
    public void 저장이안되는_테스트() {
        Human human = new Human("donghyeon",25);
        em.persist(human);


    }
}
