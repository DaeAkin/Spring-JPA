package com.donghyeon.springJpa.jpql.querydsl;

import com.donghyeon.springJpa.TestConfiguration;
import com.querydsl.jpa.impl.JPAQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class QueryDSLTests {

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
    public void 간단한_QueryDSL_테스트() {
        //준비
        JPAQuery query = new JPAQuery(em);
//        QPerson member = QMember.member;
//
//        //쿼리, 결과조회
//        List<Person> members =
//                query.from(member)
//                        .where(member.username.eq(“kim”))
//                        .list(member);
    }
}
