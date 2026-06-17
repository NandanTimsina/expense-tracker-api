package com.Project.Project11.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
    private String title;
    private Long amount;
    private String note;
    private LocalDate date;

    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;
}
