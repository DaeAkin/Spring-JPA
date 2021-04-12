package com.donghyeon.springJpa.querydsl;

import com.donghyeon.springJpa.TestConfiguration;
import com.querydsl.jpa.impl.JPAQuery;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class QueryDslTest {

    @Autowired
    private QueryDslRepository queryDslRepository;

    @Autowired
    private QueryDslJpaRepository queryDslJpaRepository;

    @PersistenceUnit
    EntityManagerFactory emf;

    private EntityManager em;

    @Before
    public void setUp() {
        em = emf.createEntityManager(); // Retrieve an application managed entity manager
        em.getTransaction().begin();
    }


    @Test
    public void find_test() {
        Customer saveCustomer = new Customer(1L,"Donghyeon" , "Min");
        em.persist(saveCustomer);

        QCustomer customer = QCustomer.customer;
        JPAQuery<Customer> query = new JPAQuery<>(em);

        Customer donghyeon = query.from(customer)
                .where(customer.firstName.eq("Donghyeon"))
                .fetchFirst();

        //AND 연산자 두개
        query.from(customer)
                .where(customer.firstName.eq("Donghyeon").and(customer.lastName.eq("Min"))).fetchFirst();

        //OR 연산자 두개
        query.from(customer)
                .where(customer.firstName.eq("Donghyeon").or(customer.lastName.eq("Min"))).fetchFirst();

        assertThat(donghyeon.getFirstName(), is(saveCustomer.getFirstName()));
    }

    @Test
    public void find_using_two_entity_test() {

    }
}
