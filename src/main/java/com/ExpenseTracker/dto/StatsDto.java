package com.ExpenseTracker.dto;

import com.ExpenseTracker.entity.Expense;
import com.ExpenseTracker.entity.Income;
import lombok.Data;

@Data
public class StatsDto {
    private Double income;
    private Double expense;
    private Income latestIncome;
    private Expense latestExpense;
    private Double balance;
    private Double minIncome;
    private Double maxIncome;
    private Double minExpense;
    private Double maxExpense;
}
