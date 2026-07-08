package com.elisabetta.taskmanager.dto;

import com.elisabetta.taskmanager.model.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateTaskDto {

    @NotBlank(message = "Il titolo è obbligatorio")
    private String title;

    private String description;

    @NotNull(message = "La priorità è obbligatoria")
    private Priority priority;

    // Getter e Setter

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
}