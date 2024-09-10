package com.ExpenseTracker.services.expense;

import com.ExpenseTracker.dto.ExpenseDto;
import com.ExpenseTracker.entity.Expense;

import java.util.List;

public interface ExpenseServices {
    public Expense postExpense(ExpenseDto expenseDto);
    public Expense updateExpense(Long id,ExpenseDto expenseDto);
    public List<Expense> getAllExpenses();
    public Expense getExpenseById(Long id);
    public void deleteExpense(Long id);
}
