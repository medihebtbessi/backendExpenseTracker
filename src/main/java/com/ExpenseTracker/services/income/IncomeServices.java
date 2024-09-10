package com.ExpenseTracker.services.income;

import com.ExpenseTracker.dto.IncomeDto;
import com.ExpenseTracker.entity.Income;

import java.util.List;

public interface IncomeServices {
    public Income postIncome(IncomeDto incomeDto);
    public List<IncomeDto> getAllIncomes();
    public Income updateIncome(Long id,IncomeDto incomeDto);
    public IncomeDto getIncomeById(Long id);
    public void deleteIncome(Long id);
}
