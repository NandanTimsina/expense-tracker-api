package com.Project.Project11.service;
import com.Project.Project11.model.Category;
import com.Project.Project11.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
