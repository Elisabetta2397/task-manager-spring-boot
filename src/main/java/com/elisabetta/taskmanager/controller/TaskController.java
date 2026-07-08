package com.elisabetta.taskmanager.controller;

import com.elisabetta.taskmanager.dto.CreateTaskDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    @GetMapping("/tasks/new")
    public String newTask(Model model) {

        model.addAttribute("createTaskDto", new CreateTaskDto());

        return "new-task";
    }

}
