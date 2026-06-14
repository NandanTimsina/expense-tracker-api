package com.Project.Project11.controller;
import com.Project.Project11.payload.ExpenseRequestDTO;
import com.Project.Project11.payload.ExpenseResponseDTO;
import com.Project.Project11.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @GetMapping("/user/expenses/{UserId}")
    public ResponseEntity<List<ExpenseResponseDTO>>  getAll(@PathVariable Long UserId){
        List<ExpenseResponseDTO> list=expenseService.getAll(UserId);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/user/{userId}/expense/{categoryName}/create")
    public ResponseEntity<ExpenseResponseDTO> createExpense(@Valid @RequestBody ExpenseRequestDTO expense,
                                                            @PathVariable String categoryName,
                                                            @PathVariable Long userId){

        ExpenseResponseDTO expenseResponseDTO=expenseService.createExpense(expense,categoryName,userId);
        return new ResponseEntity<>(expenseResponseDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("/user/expense/delete/{ExpenseId}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long ExpenseId){
        String string= expenseService.deleteExpense(ExpenseId);
        return new ResponseEntity<>(string,HttpStatus.OK);
    }

}
