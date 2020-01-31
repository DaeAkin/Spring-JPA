package com.donghyeon.springJpa.jpql.criteria;

import com.donghyeon.springJpa.TestConfiguration;


import com.donghyeon.springJpa.manytomany.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class CriteriaTests {

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
    public void 간단한_criteria_테스트() {
        Person person = new Person("donghyeon");
        em.persist(person);

        //select p from Person p where p.username = 'donghyeon' -> Criteria로 변경

        //Criteria 사용 준비
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> query = cb.createQuery(Person.class);

        //루트 클래스(조회를 시작할 클래스)
        Root<Person> m = query.from(Person.class);

        // 쿼리 생성
        CriteriaQuery<Person> cq = query.select(m).where(cb.equal(m.get("username"), "donghyeon"));
        List<Person> resultList = em.createQuery(cq).getResultList();

        assertThat(resultList.get(0)).isEqualTo(person);
    }

}
