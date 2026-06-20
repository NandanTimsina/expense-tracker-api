package com.Project.Project11.service;
import com.Project.Project11.exceptions.ResourceNotFoundException;
import com.Project.Project11.model.Role;
import com.Project.Project11.model.User;
import com.Project.Project11.payload.UserRequestDTO;
import com.Project.Project11.payload.UserResponseDTO;
import com.Project.Project11.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private  final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user=new User();
        user.setName(userRequestDTO.getName());
        //user.setPassword(userRequestDTO.getPassword());
        user.setPassword(
                passwordEncoder.encode(userRequestDTO.getPassword())
        );
        user.setEmail(userRequestDTO.getEmail());
        user.setRole(Role.USER);
        User savedUser=userRepository.save(user);
        UserResponseDTO userResponseDTO=new UserResponseDTO();

        userResponseDTO.setName(savedUser.getName());
        userResponseDTO.setUserId(savedUser.getUserId());
        userResponseDTO.setEmail(savedUser.getEmail());

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO, Long userId) {
        User existingUser =userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User ","Id: "+userId));
        existingUser.setName(userRequestDTO.getName());
        existingUser.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        existingUser.setEmail(userRequestDTO.getEmail());

        User updatedUser=userRepository.save(existingUser);

        UserResponseDTO userResponseDTO=new UserResponseDTO();
        userResponseDTO.setName(updatedUser.getName());
        userResponseDTO.setEmail(updatedUser.getEmail());
        userResponseDTO.setUserId(updatedUser.getUserId());

        return userResponseDTO;
    }

    @Override
    public String deleteUser(Long userId) {
        User existingUser=userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id: " + userId));
        userRepository.delete(existingUser);
        return "User deleted successfully ";
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users= userRepository.findAll();
        if(users.isEmpty()){
            throw new ResourceNotFoundException("User");
        }

        List<UserResponseDTO> userResponseDTOS=new ArrayList<>();

        for(User user: users){
            UserResponseDTO userObject=new UserResponseDTO();
            userObject.setUserId(user.getUserId());
            userObject.setName(user.getName());
            userObject.setEmail(user.getEmail());

            userResponseDTOS.add(userObject);
        }
        return userResponseDTOS;
    }
    }

