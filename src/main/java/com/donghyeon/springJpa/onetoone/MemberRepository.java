package com.donghyeon.springJpa.onetoone;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member,Long> {
    Optional<Member> findById(Long id);
}
