package com.example.testproject.controller;

import com.example.testproject.dto.request.UserRequest;
import com.example.testproject.dto.response.UserResponse;
import com.example.testproject.service.UserService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/v1/user")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor
public class UserController {
    UserService userService;

    @PostMapping("/post")
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/get/{id}")
    public UserResponse findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/users")
    public List<UserResponse> findAllUsers() {
        return userService.findAllUsers();
    }
}