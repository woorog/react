// src/main/java/com/example/demo/controller/UserRestController.java
package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.UserSchema;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserRepository repo;

    // CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserSchema createUser(@RequestBody UserSchema user) {
        return repo.save(user);
    }

    // READ ALL
    @GetMapping
    public List<UserSchema> listUsers() {
        return repo.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public UserSchema getUser(@PathVariable Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    // UPDATE (Builder 사용)
    @PutMapping("/{id}")
    public UserSchema updateUser(@PathVariable Long id,
                                 @RequestBody UserSchema updated) {
        UserSchema existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found: " + id));

        // Builder로 새 객체를 생성 (기존 createdAt 유지, id 포함)
        UserSchema toSave = UserSchema.builder()
            .id(existing.getId())
            .username(updated.getUsername())
            .email(updated.getEmail())
            .password(updated.getPassword())
            .created(existing.getCreated())
            .build();

        return repo.save(toSave);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
