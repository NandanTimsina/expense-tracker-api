package com.Project.Project11.controller;
import com.Project.Project11.model.Category;
import com.Project.Project11.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/admin/category/create")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
    @GetMapping("/admin/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAll();
    }

}
