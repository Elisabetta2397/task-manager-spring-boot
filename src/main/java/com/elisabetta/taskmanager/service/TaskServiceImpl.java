package com.elisabetta.taskmanager.service;

import com.elisabetta.taskmanager.dto.CreateTaskDto;
import com.elisabetta.taskmanager.dto.UpdateTaskDto;
import com.elisabetta.taskmanager.model.Task;
import com.elisabetta.taskmanager.model.User;
import com.elisabetta.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import com.elisabetta.taskmanager.model.TaskStatus;
import java.time.LocalDate;
import com.elisabetta.taskmanager.model.Priority;

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

    @Override
    public Task createTask(CreateTaskDto createTaskDto, User user) {

    Task task = new Task();

    task.setTitle(createTaskDto.getTitle());

    task.setDescription(createTaskDto.getDescription());

    task.setPriority(createTaskDto.getPriority());

    task.setStatus(TaskStatus.TODO);

    task.setCreationDate(LocalDate.now());

    task.setUser(user);

    return taskRepository.save(task);

    }

    @Override
    public void deleteTask(Long id) {

    taskRepository.deleteById(id);

    }

    @Override
    public Task getTaskById(Long id) {

    return taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task non trovato"));

    }

    @Override
    public Task updateTask(Long id, UpdateTaskDto updateTaskDto) {

    Task task = taskRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Task non trovato"));

    task.setTitle(updateTaskDto.getTitle());
    task.setDescription(updateTaskDto.getDescription());
    task.setPriority(updateTaskDto.getPriority());
    task.setStatus(updateTaskDto.getStatus());

    return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksByUserAndStatus(User user, TaskStatus status) {

        return taskRepository.findByUserAndStatus(user, status);

    }

    @Override
public List<Task> getTasksByUserAndPriority(User user, Priority priority) {

    return taskRepository.findByUserAndPriority(user, priority);

}

    @Override
public List<Task> getTasksByUserAndStatusAndPriority(User user,
                                                     TaskStatus status,
                                                     Priority priority) {

    return taskRepository.findByUserAndStatusAndPriority(user, status, priority);
}

@Override
public List<Task> searchTasksByTitle(User user, String title) {
    return taskRepository.findByUserAndTitleContainingIgnoreCase(user, title);
}
}