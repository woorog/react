// src/main/java/com/example/demo/UserRestController.java
package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {
    private final UserRepository repo;

    public UserRestController(UserRepository repo) {
        this.repo = repo;
    }

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

    // UPDATE
    @PutMapping("/{id}")
    public UserSchema updateUser(@PathVariable Long id,
                                 @RequestBody UserSchema updated) {
        return repo.findById(id)
                   .map(user -> {
                       user.setUsername(updated.getUsername());
                       user.setEmail(updated.getEmail());
                       user.setPassword(updated.getPassword());
                       return repo.save(user);
                   })
                   .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
