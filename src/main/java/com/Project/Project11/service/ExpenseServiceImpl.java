package com.Project.Project11.service;
import com.Project.Project11.exceptions.ResourceNotFoundException;
import com.Project.Project11.model.Category;
import com.Project.Project11.model.Expense;
import com.Project.Project11.model.User;
import com.Project.Project11.payload.ExpenseRequestDTO;
import com.Project.Project11.payload.ExpenseResponseDTO;
import com.Project.Project11.repository.CategoryRepository;
import com.Project.Project11.repository.ExpenseRepository;
import com.Project.Project11.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public List<ExpenseResponseDTO> getAll() {
        Authentication auth= SecurityContextHolder.getContext()
                .getAuthentication();
        String email=auth.getName();

        List<Expense> expenses= expenseRepository.findByUser_Email(email);
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
                                            String categoryName) {
        Expense expense=new Expense();

        Authentication auth=SecurityContextHolder.getContext()
                .getAuthentication();
        String email=auth.getName();
        User user=userRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("User","email: "+email));

            Category category=categoryRepository.findByCategoryName(categoryName);
            if(category==null){
                throw new ResourceNotFoundException("Category"," "+categoryName);
            }

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
        Authentication auth=SecurityContextHolder.getContext()
                        .getAuthentication();
        String email=auth.getName();
        User user=userRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("User","Email id: "+email));

        Expense expense=expenseRepository.findById(expenseId)
                        .orElseThrow(()-> new ResourceNotFoundException("Expense","Id: "+expenseId));
        if(!expense.getUser().getUserId().equals(user.getUserId())){
            throw new AccessDeniedException("You cannot delete this");
        }
        expenseRepository.delete(expense);
        return "Item deleted successfully";
    }

}
