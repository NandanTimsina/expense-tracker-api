package com.Project.Project11.service;
import com.Project.Project11.payload.ExpenseRequestDTO;
import com.Project.Project11.payload.ExpenseResponseDTO;

import java.util.List;

public interface ExpenseService {

    List<ExpenseResponseDTO> getAll();
    ExpenseResponseDTO createExpense(ExpenseRequestDTO expense, String CategoryName);
    String deleteExpense(Long expenseId);
}
