package com.Project.Project11.service;

import com.Project.Project11.model.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAll(Long UserId);

    Expense createExpense(Expense expense,Long categoryId,Long userId);

    String deleteExpense(Long expenseId);
}
