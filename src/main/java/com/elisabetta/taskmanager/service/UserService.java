package com.elisabetta.taskmanager.service;

import com.elisabetta.taskmanager.dto.RegisterUserDto;
import com.elisabetta.taskmanager.model.User;

public interface UserService {
    User registerUser(RegisterUserDto registerUserDto);
}
