package com.elisabetta.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.elisabetta.taskmanager.dto.RegisterUserDto;
import com.elisabetta.taskmanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        @Valid @ModelAttribute("registerUserDto") RegisterUserDto registerUserDto,
        BindingResult bindingResult,
        Model model,
        RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
        return "register";
    }

    try {

        userService.registerUser(registerUserDto);

    } catch (IllegalArgumentException e) {

        model.addAttribute("emailError", e.getMessage());

        return "register";
    }

    redirectAttributes.addFlashAttribute(
            "successMessage",
            "Registrazione completata con successo!"
    );

    return "redirect:/";
}

}