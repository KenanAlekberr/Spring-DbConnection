package com.example.testproject.service.impl;

import com.example.testproject.dto.request.UserRequest;
import com.example.testproject.dto.response.UserResponse;
import com.example.testproject.exception.UserNotFoundException;
import com.example.testproject.model.UserEntity;
import com.example.testproject.repository.UserRepository;
import com.example.testproject.service.UserService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest request) {
        UserEntity user = new UserEntity();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAge(request.getAge());

        UserEntity savedUser = userRepository.save(user);

        return new UserResponse(savedUser.getId(), savedUser.getFirstName(), savedUser.getLastName(), savedUser.getAge());
    }

    @Override
    public UserResponse findUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found by id: " + id));
        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getAge());
    }

    @Override
    public List<UserResponse> findAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();

        for (UserEntity user : users) {
            userResponses.add(new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getAge()));
        }

        return userResponses;
    }
}