package com.elisabetta.taskmanager.service;

import com.elisabetta.taskmanager.dto.CreateTaskDto;
import com.elisabetta.taskmanager.dto.UpdateTaskDto;
import com.elisabetta.taskmanager.model.Task;
import com.elisabetta.taskmanager.model.User;

import java.util.List;

public interface TaskService {

    List<Task> getTasksByUser(User user);
    Task createTask(CreateTaskDto createTaskDto, User user);
    void deleteTask(Long id);
    Task getTaskById(Long id);
   Task updateTask(Long id, UpdateTaskDto updateTaskDto);

}
