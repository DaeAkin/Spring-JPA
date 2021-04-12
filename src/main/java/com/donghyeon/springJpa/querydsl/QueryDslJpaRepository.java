package com.donghyeon.springJpa.querydsl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryDslJpaRepository extends JpaRepository<Customer,Long> {
}
