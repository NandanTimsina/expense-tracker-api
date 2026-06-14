package com.Project.Project11.service;
import com.Project.Project11.model.Category;
import com.Project.Project11.model.Expense;
import com.Project.Project11.model.User;
import com.Project.Project11.payload.ExpenseRequestDTO;
import com.Project.Project11.payload.ExpenseResponseDTO;
import com.Project.Project11.repository.CategoryRepository;
import com.Project.Project11.repository.ExpenseRepository;
import com.Project.Project11.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public List<ExpenseResponseDTO> getAll(Long UserId) {
        List<Expense> expenses= expenseRepository.findByUser_UserId(UserId);
        List<ExpenseResponseDTO> expenseResponseDTOS=new ArrayList<>();

        for(Expense expense: expenses){
            ExpenseResponseDTO expenseResponseDTO=new ExpenseResponseDTO();

            expenseResponseDTO.setExpenseId(expense.getExpenseId());
            expenseResponseDTO.setTitle(expense.getTitle());
            expenseResponseDTO.setAmount(expense.getAmount());
            expenseResponseDTO.setDate(expense.getDate());
            expenseResponseDTO.setNote(expense.getNote());
            expenseResponseDTO.setUserId(expense.getUser().getUserId());
            expenseResponseDTO.setCategoryName(expense.getCategory().getCategoryName());

            expenseResponseDTOS.add(expenseResponseDTO);
        }
        return expenseResponseDTOS;
    }

    @Override
    public ExpenseResponseDTO createExpense(ExpenseRequestDTO expenseRequestDTO,
                                            String categoryName, Long userId) {
        Expense expense=new Expense();
        User user =userRepository.findById(userId)
                .orElseThrow(RuntimeException::new);
        Category category=categoryRepository.findByCategoryName(categoryName);

        expense.setUser(user);
        expense.setCategory(category);
        expense.setTitle(expenseRequestDTO.getTitle());
        expense.setDate(expenseRequestDTO.getDate());
        expense.setNote(expenseRequestDTO.getNote());
        expense.setAmount(expenseRequestDTO.getAmount());
        Expense savedExpense=expenseRepository.save(expense);

        ExpenseResponseDTO expenseResponseDTO=new ExpenseResponseDTO();

        expenseResponseDTO.setTitle(savedExpense.getTitle());
        expenseResponseDTO.setExpenseId(savedExpense.getExpenseId());
        expenseResponseDTO.setAmount(savedExpense.getAmount());
        expenseResponseDTO.setDate(savedExpense.getDate());
        expenseResponseDTO.setNote(savedExpense.getNote());
        expenseResponseDTO.setUserId(savedExpense.getUser().getUserId());
        expenseResponseDTO.setCategoryName(savedExpense.getCategory().getCategoryName());

        return expenseResponseDTO;


    }

    @Override
    public String deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);
        return "Item deleted successfully";
    }

}
