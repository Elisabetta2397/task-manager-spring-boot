package com.elisabetta.taskmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class RegisterUserDto {

    @NotBlank(message = "Il campo username è obbligatorio")
    @Size(min = 3, max = 20, message = "Lo username deve contenere tra 3 e 20 caratteri")
    private String username;

    @NotBlank(message = "Il campo email è obbligatorio")
    @Email(message = "Inserisci email valida")
    private String email;

    @NotBlank(message = "La password è obbligatoria")
    @Size(min = 8, message = "La password deve contenere almeno 8 caratteri")
    private String password;

    public RegisterUserDto() {
    }

    public RegisterUserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
