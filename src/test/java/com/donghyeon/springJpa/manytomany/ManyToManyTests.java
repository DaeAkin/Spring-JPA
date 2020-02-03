package com.donghyeon.springJpa.manytomany;

import com.donghyeon.springJpa.TestConfiguration;
import com.donghyeon.springJpa.global.domain.Person;
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
public class ManyToManyTests {

    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;

    @Autowired
    PersonRepository personRepository;

//    @Autowired
//    OrderedRepository orderedRepository;
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Test
//    public void manyToManyTests() {
//        Person person = new Person("donghyeon");
//        Product product = new Product("Large Pizza");
//
//        person = personRepository.save(person);
//        product = productRepository.save(product);
//
//        Ordered ordered = new Ordered(person,product,3);
//
//        ordered = orderedRepository.save(ordered);
//
//        System.out.println(personRepository.findById(person.getId()).toString());
//        System.out.println(productRepository.findById(product.getId()).toString());
//        System.out.println(orderedRepository.findById(ordered.getId()).toString());
//
//
//    }

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
    public void manyToManyTests() {
        Product product = new Product("Large Pizza"); //상품1 저장
        em.persist(product);

        Person person = new Person("donghyeon");
        em.persist(person);

        Ordered ordered = new Ordered();
        ordered.setProduct(product);
        ordered.setPerson(person);
        ordered.setOrderMount(5);
        em.persist(ordered);
    }
}
