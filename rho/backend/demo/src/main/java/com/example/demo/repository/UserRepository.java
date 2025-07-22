// src/main/java/com/example/demo/UserRepository.java
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.UserSchema;

public interface UserRepository extends JpaRepository<UserSchema, Long> {
    // 추가 쿼리 메서드가 필요하면 여기에 선언
}
