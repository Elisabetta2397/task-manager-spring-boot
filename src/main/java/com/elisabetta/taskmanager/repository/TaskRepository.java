package com.elisabetta.taskmanager.repository;

import com.elisabetta.taskmanager.model.Task;
import com.elisabetta.taskmanager.model.TaskStatus;
import com.elisabetta.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.elisabetta.taskmanager.model.Priority;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);
    List<Task> findByUserOrderByCreationDateDesc(User user);
    List<Task> findByUserAndStatus(User user, TaskStatus status);
    List<Task> findByUserAndPriority(User user, Priority priority);
    List<Task> findByUserAndStatusAndPriority(User user,
                                          TaskStatus status,
                                          Priority priority);
    List<Task> findByUserAndTitleContainingIgnoreCase(User user, String title);
    long countByUser(User user);

    long countByUserAndStatus(User user, TaskStatus status);
}