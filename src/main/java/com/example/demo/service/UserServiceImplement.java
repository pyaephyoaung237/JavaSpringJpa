package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Pojo.UserLogin;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImplement  {

    private UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }
    
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    public User login(UserLogin userLogin) {

        Optional<User> user = userRepository.findByEmailAndPassword(
                userLogin.getEmail(),
                userLogin.getPassword()
        );

        return user.orElse(null);
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}