    package com.Project.Project11.model;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import jakarta.persistence.*;
    import jakarta.validation.constraints.NotBlank;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.List;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long categoryId;
        private String categoryName;

        @OneToMany(mappedBy = "category")
        private List<Expense> expense;


    }
