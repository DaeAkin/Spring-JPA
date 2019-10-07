package com.donghyeon.springJpa.onetoone;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockerRepository extends CrudRepository<Locker,Long> {
}
