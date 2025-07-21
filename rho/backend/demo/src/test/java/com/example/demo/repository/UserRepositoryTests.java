// src/main/java/com/example/demo/UserRepository.java
package com.example.demo.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import lombok.extern.log4j.Log4j2;
@ActiveProfiles("test")
@SpringBootTest
@Log4j2
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1() {
        Assertions.assertNotNull(userRepository);
        log.info("userRepository class: " + userRepository.getClass().getName());
    }
}
