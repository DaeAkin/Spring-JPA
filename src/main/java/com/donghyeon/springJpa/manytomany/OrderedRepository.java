package com.donghyeon.springJpa.manytomany;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedRepository extends CrudRepository<Ordered,Long> {
}
