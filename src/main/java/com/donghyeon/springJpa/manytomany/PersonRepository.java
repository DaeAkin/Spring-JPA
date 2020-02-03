package com.donghyeon.springJpa.manytomany;

import com.donghyeon.springJpa.global.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
    Optional<Person> findById(Long id);
}
