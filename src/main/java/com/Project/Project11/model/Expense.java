package com.Project.Project11.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    @Id
    private Long expenseId;
    private String title;
    private Long amount;
    private String note;

}
