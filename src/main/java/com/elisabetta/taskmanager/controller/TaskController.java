package com.elisabetta.taskmanager.controller;

import com.elisabetta.taskmanager.dto.CreateTaskDto;
import com.elisabetta.taskmanager.model.User;
import com.elisabetta.taskmanager.repository.UserRepository;
import com.elisabetta.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final UserRepository userRepository;

    public TaskController(TaskService taskService,
                          UserRepository userRepository) {

        this.taskService = taskService;
        this.userRepository = userRepository;
    }

    @GetMapping("/tasks/new")
    public String newTask(Model model) {

        model.addAttribute("createTaskDto", new CreateTaskDto());

        return "new-task";
    }

    @PostMapping("/tasks")
    public String createTask(
            @Valid CreateTaskDto createTaskDto,
            BindingResult bindingResult,
            Authentication authentication) {

        if (bindingResult.hasErrors()) {
            return "new-task";
        }

        User user = userRepository
                .findByEmail(authentication.getName())
                .orElseThrow();

        taskService.createTask(createTaskDto, user);

        return "redirect:/dashboard";
    }

    @PostMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable Long id) {

    taskService.deleteTask(id);

    return "redirect:/dashboard";

}
}
