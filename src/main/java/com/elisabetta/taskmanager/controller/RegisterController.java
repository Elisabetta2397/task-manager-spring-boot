package com.elisabetta.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.elisabetta.taskmanager.dto.RegisterUserDto;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showRegisterForm(Model model) {

        model.addAttribute("registerUserDto", new RegisterUserDto());

        return "register";
    }

}
