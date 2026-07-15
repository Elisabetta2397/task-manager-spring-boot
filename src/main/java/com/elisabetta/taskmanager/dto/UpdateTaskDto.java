package com.elisabetta.taskmanager.dto;

import com.elisabetta.taskmanager.model.Priority;
import com.elisabetta.taskmanager.model.TaskStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateTaskDto {

    @NotBlank(message = "Il titolo è obbligatorio.")
    private String title;

    private String description;

    @NotNull(message = "La priorità è obbligatoria.")
    private Priority priority;

    public UpdateTaskDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @NotNull(message = "Lo stato è obbligatorio.")
    private TaskStatus status;

    public TaskStatus getStatus() {
    return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
