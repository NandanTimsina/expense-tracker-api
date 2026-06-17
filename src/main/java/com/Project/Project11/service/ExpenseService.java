package com.Project.Project11.service;
import com.Project.Project11.payload.ExpenseRequestDTO;
import com.Project.Project11.payload.ExpenseResponseDTO;

import java.util.List;

public interface ExpenseService {
    List<ExpenseResponseDTO> getAll(Long UserId);

    ExpenseResponseDTO createExpense(ExpenseRequestDTO expense, String CategoryName, Long userId);

    String deleteExpense(Long expenseId);
}
