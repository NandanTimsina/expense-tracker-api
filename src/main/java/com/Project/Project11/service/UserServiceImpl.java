package com.Project.Project11.service;

import com.Project.Project11.model.User;
import com.Project.Project11.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private  final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user, Long userId) {
        User existingUser =userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with Id "+userId));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public String deleteUser(Long userId) {
        User existingUser=userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with Id"+userId));
        userRepository.delete(existingUser);
        return "User deleted successfully ";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
