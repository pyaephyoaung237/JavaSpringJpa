package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.other.UserLogin;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImplement  {

    private UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }
    public User login(UserLogin userLogin) {

        Optional<User> user = userRepository.findByEmailAndPassword(
                userLogin.getEmail(),
                userLogin.getPassword()
        );

        return user.orElse(null);
    }
}