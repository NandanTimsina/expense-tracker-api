package com.Project.Project11.controller;
import com.Project.Project11.payload.UserRequestDTO;
import com.Project.Project11.payload.UserResponseDTO;
import com.Project.Project11.service.ExpenseService;
import com.Project.Project11.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

   private final ExpenseService expenseService;
    @GetMapping("/admin/users")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<UserResponseDTO> list= userService.getAllUsers();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @PutMapping("/admin/update/{userId}")
    public ResponseEntity<UserResponseDTO>  updateUser(@Valid @RequestBody UserRequestDTO userRequestDTO, @PathVariable Long userId){
        UserResponseDTO userResponseDTO=userService.updateUser(userRequestDTO,userId);
        return new ResponseEntity<>(userResponseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/admin/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        String string= userService.deleteUser(userId);
        return new ResponseEntity<>(string,HttpStatus.OK);
    }
    @PostMapping("/user/signup")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO= userService.createUser(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

}
