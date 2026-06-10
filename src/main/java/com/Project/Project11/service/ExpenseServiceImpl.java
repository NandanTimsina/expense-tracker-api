package com.Project.Project11.service;
import com.Project.Project11.model.Category;
import com.Project.Project11.model.Expense;
import com.Project.Project11.model.User;
import com.Project.Project11.repository.CategoryRepository;
import com.Project.Project11.repository.ExpenseRepository;
import com.Project.Project11.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public List<Expense> getAll(Long UserId) {
        return expenseRepository.findByUser_UserId(UserId);
    }

    @Override
    public Expense createExpense(Expense expense,Long categoryId,Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(RuntimeException::new);
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(RuntimeException::new);
        expense.setUser(user);
        expense.setCategory(category);
        return expenseRepository.save(expense);
    }

    @Override
    public String deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);
        return "Item deleted successfully";
    }


}
