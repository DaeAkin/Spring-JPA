package com.donghyeon.springJpa.jpql;

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
import javax.persistence.Query;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class JpqlTests {

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
    public void 간단한_jpql_테스트() {
        Person person = new Person("donghyeon");
        em.persist(person);
        //select person0_.person_id as person_i1_4_, person0_.username as username2_4_ from person person0_ where person0_.username='donghyeon'
        Query query = em.createQuery("select p from Person p where p.username = 'donghyeon' ");

        int i = query.getResultList().indexOf(person);

        assertThat(person).isEqualTo(query.getResultList().get(i));
    }

}
