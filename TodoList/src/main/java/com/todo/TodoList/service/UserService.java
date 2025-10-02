package com.todo.TodoList.service;

import com.todo.TodoList.models.Todo;
import com.todo.TodoList.models.User;
import com.todo.TodoList.repo.TodoRepository;
import com.todo.TodoList.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return  userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
    }
    
}
