package com.elisabetta.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.elisabetta.taskmanager.dto.RegisterUserDto;
import com.elisabetta.taskmanager.service.UserService;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {

        model.addAttribute("registerUserDto", new RegisterUserDto());

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute RegisterUserDto registerUserDto) {

        userService.registerUser(registerUserDto);

        return "redirect:/";
    }

}