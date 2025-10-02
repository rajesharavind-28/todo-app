package com.todo.TodoList.repo;

import com.todo.TodoList.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Gets user by email
    Optional<User> findByEmail(String email);
}
