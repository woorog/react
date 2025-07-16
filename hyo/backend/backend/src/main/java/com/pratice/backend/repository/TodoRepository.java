package com.pratice.backend.repository;

import com.pratice.backend.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
  /** 기초적인 CRUD는 상속으로 구현되어있음   */

}
