package com.Project.Project11.controller;
import com.Project.Project11.model.Category;
import com.Project.Project11.payload.CategoryRequestDTO;
import com.Project.Project11.payload.CategoryResponseDTO;
import com.Project.Project11.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/admin/category/create")
    public ResponseEntity<CategoryResponseDTO> createCategory(@Valid  @RequestBody CategoryRequestDTO categoryRequestDTO){
        CategoryResponseDTO categoryResponseDTO = categoryService.createCategory(categoryRequestDTO);
        return new ResponseEntity<>(categoryResponseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/admin/categories")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories(){
        List<CategoryResponseDTO> categoryResponseDTOS= categoryService.getAll();
        return new ResponseEntity<>(categoryResponseDTOS,HttpStatus.OK);
    }

}
