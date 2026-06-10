package com.Project.Project11.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
    @NotBlank
    private String title;
    @Size(min = 0,message = "Enter a valid amount")
    private Long amount;
    private String note;

    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;
}
