package com.Project.Project11.service;
import com.Project.Project11.model.Category;
import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> getAll();
}
