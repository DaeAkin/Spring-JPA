package com.donghyeon.springJpa.repo;

import com.donghyeon.springJpa.onetomanyerror.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board,Long> {
}
