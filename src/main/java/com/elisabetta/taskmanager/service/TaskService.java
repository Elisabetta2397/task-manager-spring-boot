package com.elisabetta.taskmanager.service;

import com.elisabetta.taskmanager.dto.CreateTaskDto;
import com.elisabetta.taskmanager.dto.UpdateTaskDto;
import com.elisabetta.taskmanager.model.Task;
import com.elisabetta.taskmanager.model.TaskStatus;
import com.elisabetta.taskmanager.model.User;
import com.elisabetta.taskmanager.model.Priority;

import java.util.List;

public interface TaskService {

    List<Task> getTasksByUser(User user);
    Task createTask(CreateTaskDto createTaskDto, User user);
    void deleteTask(Long id);
    Task getTaskById(Long id);
    Task updateTask(Long id, UpdateTaskDto updateTaskDto);
    List<Task> getTasksByUserAndStatus(User user, TaskStatus status);
    List<Task> getTasksByUserAndPriority(User user, Priority priority);
    List<Task> getTasksByUserAndStatusAndPriority(User user,
                                              TaskStatus status,
                                              Priority priority);

}
