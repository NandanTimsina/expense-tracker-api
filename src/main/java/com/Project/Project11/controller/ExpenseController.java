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

    @GetMapping("/user/expenses")
    public ResponseEntity<List<ExpenseResponseDTO>>  getAll(){
        List<ExpenseResponseDTO> list=expenseService.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/user/expense/{categoryName}/create")
    public ResponseEntity<ExpenseResponseDTO> createExpense(@Valid @RequestBody ExpenseRequestDTO expense,
                                                            @PathVariable String categoryName
                                                            ){

        ExpenseResponseDTO expenseResponseDTO=expenseService.createExpense(expense,categoryName);
        return new ResponseEntity<>(expenseResponseDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("/user/expense/delete/{expenseId}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long expenseId){
        String string= expenseService.deleteExpense(expenseId);
        return new ResponseEntity<>(string,HttpStatus.OK);
    }

}
