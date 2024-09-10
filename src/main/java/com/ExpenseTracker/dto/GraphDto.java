package com.ExpenseTracker.dto;

import com.ExpenseTracker.entity.Expense;
import com.ExpenseTracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDto {
    private List<Expense> expenseList;
    private List<Income> incomeList;
}
