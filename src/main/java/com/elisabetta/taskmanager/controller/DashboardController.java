package com.elisabetta.taskmanager.controller;

import com.elisabetta.taskmanager.model.User;
import com.elisabetta.taskmanager.repository.UserRepository;
import com.elisabetta.taskmanager.service.TaskService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final TaskService taskService;
    private final UserRepository userRepository;

    public DashboardController(TaskService taskService,
                               UserRepository userRepository) {

        this.taskService = taskService;
        this.userRepository = userRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication,
                            Model model) {

        User user = userRepository
                .findByEmail(authentication.getName())
                .orElseThrow();

        model.addAttribute("tasks",
                taskService.getTasksByUser(user));

        model.addAttribute("username",
                user.getUsername());

        return "dashboard";
    }
}