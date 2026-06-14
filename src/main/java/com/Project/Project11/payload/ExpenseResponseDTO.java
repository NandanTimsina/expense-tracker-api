package com.Project.Project11.payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponseDTO {
    private Long expenseId;
    private String title;
    private Long amount;
    private String note;
    private LocalDate date;

    private Long userId;
    private String categoryName;
}
