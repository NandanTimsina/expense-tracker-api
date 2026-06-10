package com.Project.Project11.controller;

import com.Project.Project11.model.Expense;
import com.Project.Project11.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @GetMapping("/user/expenses/{UserId}")
    public List<Expense> getAll(@PathVariable Long UserId){
        return expenseService.getAll(UserId);
    }

    @PostMapping("/user/{userId}/expense/{categoryId}/create")
    public Expense createExpense(@RequestBody Expense expense,@PathVariable Long categoryId,
                                 @PathVariable Long userId){
        return expenseService.createExpense(expense,categoryId,userId);
    }
    @DeleteMapping("/user/expense/delete/{ExpenseId}")
    public String deleteExpense(@PathVariable Long ExpenseId){
        return expenseService.deleteExpense(ExpenseId);
    }

}
