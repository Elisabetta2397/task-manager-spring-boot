package com.elisabetta.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elisabetta.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}