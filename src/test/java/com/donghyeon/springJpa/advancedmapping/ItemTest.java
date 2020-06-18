package com.donghyeon.springJpa.advancedmapping;

import com.donghyeon.springJpa.TestConfiguration;
import com.donghyeon.springJpa.manytomany.PersonRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class ItemTest {

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
    public void test() {
        Item item = new Item("아이템",5000);
        em.persist(item);
    }

}
