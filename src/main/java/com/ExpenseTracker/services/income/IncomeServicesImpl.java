package com.ExpenseTracker.services.income;

import com.ExpenseTracker.dto.IncomeDto;
import com.ExpenseTracker.entity.Income;
import com.ExpenseTracker.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncomeServicesImpl implements IncomeServices {
    private final IncomeRepository incomeRepository;
    public Income postIncome(IncomeDto incomeDto){
        return saveOrUpdateIncome(new Income(),incomeDto);
    }
    public Income updateIncome(Long id,IncomeDto incomeDto){
        Optional<Income> optionalIncome=incomeRepository.findById(id);
        if (optionalIncome.isPresent()){
            return saveOrUpdateIncome(optionalIncome.get(),incomeDto);
        }else {
            throw new EntityNotFoundException("Income is not present with id "+id);
        }
    }
    private Income saveOrUpdateIncome(Income income, IncomeDto incomeDto){
        income.setTitle(incomeDto.getTitle());
        income.setDate(incomeDto.getDate());
        income.setAmount(incomeDto.getAmount());
        income.setCategory(incomeDto.getCategory());
        income.setDescription(incomeDto.getDescription());
        return incomeRepository.save(income);
    }



    public List<IncomeDto> getAllIncomes(){
        return incomeRepository.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDto)
                .toList();
    }

    public IncomeDto getIncomeById(Long id){
        Optional<Income> optionalIncome=incomeRepository.findById(id);
        if (optionalIncome.isPresent()){
            return optionalIncome.get().getIncomeDto();

        }else {
            throw new EntityNotFoundException("Income is not present with id "+id);
        }
    }

    public void deleteIncome(Long id){
        Optional<Income> optionalIncome=incomeRepository.findById(id);
        if (optionalIncome.isPresent()){
            incomeRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Income is not present with id "+id);
        }
    }
}
