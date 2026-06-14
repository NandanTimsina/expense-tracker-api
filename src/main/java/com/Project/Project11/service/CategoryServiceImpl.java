package com.Project.Project11.service;
import com.Project.Project11.model.Category;
import com.Project.Project11.payload.CategoryRequestDTO;
import com.Project.Project11.payload.CategoryResponseDTO;
import com.Project.Project11.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {

        Category category=new Category();
        category.setCategoryName(categoryRequestDTO.getCategoryName());
        Category savedCategory=categoryRepository.save(category);

        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(savedCategory.getCategoryName());
        categoryResponseDTO.setCategoryId(savedCategory.getCategoryId());
        return categoryResponseDTO;

    }
    @Override
    public List<CategoryResponseDTO> getAll() {
        List<Category> categories=categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOS=new ArrayList<>();

        for(Category category: categories){
            CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();

            categoryResponseDTO.setCategoryName(category.getCategoryName());
            categoryResponseDTO.setCategoryId(category.getCategoryId());
            categoryResponseDTOS.add(categoryResponseDTO);
        }
        return categoryResponseDTOS;
    }
}
