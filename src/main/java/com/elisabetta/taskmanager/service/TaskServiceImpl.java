package com.elisabetta.taskmanager.service;

import com.elisabetta.taskmanager.model.Task;
import com.elisabetta.taskmanager.model.User;
import com.elisabetta.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasksByUser(User user) {

        return taskRepository.findByUserOrderByCreationDateDesc(user);

    }

}