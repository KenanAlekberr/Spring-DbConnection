package com.example.testproject.service;

import com.example.testproject.dto.request.UserRequest;
import com.example.testproject.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);

    UserResponse findUserById(Long id);

    List<UserResponse> findAllUsers();
}