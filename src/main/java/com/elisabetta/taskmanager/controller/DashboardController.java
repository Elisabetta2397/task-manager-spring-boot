package com.elisabetta.taskmanager.controller;

import com.elisabetta.taskmanager.model.TaskStatus;
import com.elisabetta.taskmanager.model.User;
import com.elisabetta.taskmanager.repository.UserRepository;
import com.elisabetta.taskmanager.service.TaskService;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.elisabetta.taskmanager.model.Priority;
import com.elisabetta.taskmanager.model.Task;

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
        @RequestParam(required = false) String title,
        Authentication authentication,
        Model model) {
    User user = userRepository
            .findByEmail(authentication.getName())
            .orElseThrow();

    List<Task> tasks;

   if (title != null && !title.isBlank()) {

    tasks = taskService.searchTasksByTitle(user, title);

} else if (status != null && priority != null) {

    tasks = taskService.getTasksByUserAndStatusAndPriority(user, status, priority);

} else if (status != null) {

    tasks = taskService.getTasksByUserAndStatus(user, status);

} else if (priority != null) {

    tasks = taskService.getTasksByUserAndPriority(user, priority);

} else {

    tasks = taskService.getTasksByUser(user);

}

    model.addAttribute("statuses", TaskStatus.values());
    model.addAttribute("selectedStatus", status);
    model.addAttribute("priorities", Priority.values());
        model.addAttribute("selectedPriority", priority);

    model.addAttribute("username",
            user.getUsername());
    model.addAttribute("searchTitle", title);
    model.addAttribute("tasks", tasks);
    model.addAttribute(
        "totalTasks",
        taskService.countTasksByUser(user));

    model.addAttribute(
        "todoTasks",
        taskService.countTasksByUserAndStatus(
                user,
                TaskStatus.TODO));

    model.addAttribute(
        "inProgressTasks",
        taskService.countTasksByUserAndStatus(
                user,
                TaskStatus.IN_PROGRESS));

    model.addAttribute(
        "completedTasks",
        taskService.countTasksByUserAndStatus(
                user,
                TaskStatus.COMPLETED));

    return "dashboard";
        }
}