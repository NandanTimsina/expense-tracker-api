package com.Project.Project11.controller;
import com.Project.Project11.model.Expense;
import com.Project.Project11.model.User;
import com.Project.Project11.service.ExpenseService;
import com.Project.Project11.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;
   private final ExpenseService expenseService;
    @GetMapping("/admin/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PutMapping("/admin/update/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable Long userId){
        return userService.updateUser(user,userId);
    }
    @DeleteMapping("/admin/delete/{userId}")
    public String deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }
    @PostMapping("/user/signup")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
