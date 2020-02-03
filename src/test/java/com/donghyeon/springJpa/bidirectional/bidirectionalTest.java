package com.donghyeon.springJpa.bidirectional;

import com.donghyeon.springJpa.TestConfiguration;
import com.donghyeon.springJpa.global.domain.Human;
import com.donghyeon.springJpa.global.domain.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

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
        em.getTransaction().begin();
    }

    @After
    public void finish() {
        em.getTransaction().commit();
    }
    @Test
    public void 저장이안되는_테스트() {

//        //사람1
//        Human human1 = new Human("donghyeon",25);
//        em.persist(human1); //INSERT human1
//        //사람2
//        Human human2 = new Human("gildong",23);
//        em.persist(human2); //INSERT human2
//
//        Team team1 = new Team("토트넘");
//        //주인이 아닌 곳에만 연관관계 설정
//        team1.getHumans().add(human1);
//        team1.getHumans().add(human2);
//        em.persist(team1); //INSERT team , UPDATE-HUMAN1.fk, UPDATE-HUMAN2.fk

    }

//    @Test
//    public void 순수한객체_양방향_테스트() {
//        //팀1
//        Team team1 = new Team("토트넘");
//        Human human1 = new Human("donghyeon",25);
//        Human human2 = new Human("donghyeon",25);
//
//        //연관관계 설정
//        human1.setTeam(team1);
//
//        human2.setTeam(team1);
//
//        List<Human> humans = team1.getHumans();
//
//        assertThat(humans.size()).isEqualTo(2);
//
//    }
}
