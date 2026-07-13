package com.elisabetta.taskmanager.repository;

import com.elisabetta.taskmanager.model.Task;
import com.elisabetta.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);
    List<Task> findByUserOrderByCreationDateDesc(User user);
    

}