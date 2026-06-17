package com.Project.Project11.payload;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRequestDTO {
    @NotBlank
    private String title;
    @Min(1)
    private Long amount;
    private String note;
    @NotNull
    private LocalDate date;
    private Long userId;
    private Long categoryName;
}
