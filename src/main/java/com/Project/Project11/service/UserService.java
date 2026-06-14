package com.Project.Project11.service;

import com.Project.Project11.model.Expense;
import com.Project.Project11.model.User;
import com.Project.Project11.payload.ExpenseResponseDTO;
import com.Project.Project11.payload.UserRequestDTO;
import com.Project.Project11.payload.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO updateUser(UserRequestDTO userRequestDTO,Long userId);
    String  deleteUser(Long userId);
    List<UserResponseDTO> getAllUsers();
}
