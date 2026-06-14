package com.Project.Project11.service;
import com.Project.Project11.payload.CategoryRequestDTO;
import com.Project.Project11.payload.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);
    List<CategoryResponseDTO> getAll();
}
