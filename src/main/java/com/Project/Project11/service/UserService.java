package com.Project.Project11.service;

import com.Project.Project11.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user,Long userId);
    String  deleteUser(Long userId);
    List<User> getAllUsers();
}
