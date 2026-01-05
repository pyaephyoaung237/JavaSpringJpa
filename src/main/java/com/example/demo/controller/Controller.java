package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.other.UserLogin;
import com.example.demo.repository.UserRepository;

import com.example.demo.service.UserServiceImplement;

@org.springframework.stereotype.Controller
public class Controller {
	


@Autowired
private UserRepository userRepository; 

@Autowired
private UserServiceImplement userService;

@GetMapping("/register")
public String showRegister(Model model) {
    model.addAttribute("user", new User());
    return "register";
}

@PostMapping("/register")
public String saveUser(@ModelAttribute User user) {
    userRepository.save(user);
    return "index";
}

@GetMapping("/userLogin")
public String  loginUser(Model model) {
	model.addAttribute("userLogin", new UserLogin());
	return "login";
}

@PostMapping("/userlogin")
public String loginUser(@ModelAttribute UserLogin userLogin, Model model) {
    User user = userService.login(userLogin);

    if (user != null) {
        model.addAttribute("userName", user.getFullName());
        return "save"; 
    } else {
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }
}

@GetMapping("/admin")
public String adminLogin(Model model) {
	return "admin";
}

@GetMapping("/admin/addProduct")
public String adminAddProduct(Model model) {
	return "addProduct";
}

}
