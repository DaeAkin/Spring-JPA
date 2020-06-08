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
        Album album = new Album("신나는 노래",500,"동현");
        Computer computer = new Computer("IMac",500000,"Apple");
        Food food = new Food("목살 스테이크 샐러드" , 6500,380);

        em.persist(album);
        em.persist(computer);
        em.persist(food);

//        em.getTransaction().commit();

//        em.detach(album);
//        System.out.println("---- select ----");
//            Album album1 = em.find(Album.class, 1L);
//        System.out.println(album1.name);

    }

}
