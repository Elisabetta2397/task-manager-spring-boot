package com.elisabetta.taskmanager.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.elisabetta.taskmanager.dto.RegisterUserDto;
import com.elisabetta.taskmanager.model.User;
import com.elisabetta.taskmanager.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(RegisterUserDto registerUserDto) {

        if (userRepository.findByEmail(registerUserDto.getEmail()).isPresent()) {

            throw new RuntimeException("Email già registrata");
        }

        User user = new User();

        user.setUsername(registerUserDto.getUsername());

        user.setEmail(registerUserDto.getEmail());

        user.setPassword(
                passwordEncoder.encode(registerUserDto.getPassword())
        );

        return userRepository.save(user);
    }
}