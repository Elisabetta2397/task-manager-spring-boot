package com.elisabetta.taskmanager.controller;

import com.elisabetta.taskmanager.model.TaskStatus;
import com.elisabetta.taskmanager.model.User;
import com.elisabetta.taskmanager.repository.UserRepository;
import com.elisabetta.taskmanager.service.TaskService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.elisabetta.taskmanager.model.Priority;

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
public String dashboard(
        @RequestParam(required = false) TaskStatus status,
        @RequestParam(required = false) Priority priority,
        Authentication authentication,
        Model model) {
    User user = userRepository
            .findByEmail(authentication.getName())
            .orElseThrow();

   if (status != null && priority != null) {

    model.addAttribute(
            "tasks",
            taskService.getTasksByUserAndStatusAndPriority(user, status, priority)
    );

} else if (status != null) {

    model.addAttribute(
            "tasks",
            taskService.getTasksByUserAndStatus(user, status)
    );

} else if (priority != null) {

    model.addAttribute(
            "tasks",
            taskService.getTasksByUserAndPriority(user, priority)
    );

} else {

    model.addAttribute(
            "tasks",
            taskService.getTasksByUser(user)
    );

}

    model.addAttribute("statuses", TaskStatus.values());
    model.addAttribute("selectedStatus", status);
    model.addAttribute("priorities", Priority.values());
        model.addAttribute("selectedPriority", priority);

    model.addAttribute("username",
            user.getUsername());

    return "dashboard";
        }
}