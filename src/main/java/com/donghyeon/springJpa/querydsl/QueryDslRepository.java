package com.donghyeon.springJpa.querydsl;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.hibernate.HibernateQuery;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.donghyeon.springJpa.querydsl.QCustomer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QueryDslRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void doSomething() {

        QCustomer customer = QCustomer.customer;
        JPAQuery<Customer> query = new JPAQuery<>(entityManager);
        List<Customer> results = query.from(customer)
                .where(customer.firstName.eq("Bob"))
                .fetchResults()
                .getResults();
    }
}
