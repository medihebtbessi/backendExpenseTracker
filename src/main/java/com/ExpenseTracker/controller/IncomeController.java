package com.ExpenseTracker.controller;

import com.ExpenseTracker.dto.IncomeDto;
import com.ExpenseTracker.entity.Income;
import com.ExpenseTracker.services.income.IncomeServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/income")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IncomeController {

    private final IncomeServices incomeServices;

    @PostMapping("/add")
    public ResponseEntity<?> postIncome(@RequestBody IncomeDto incomeDto){
        Income createdincome=incomeServices.postIncome(incomeDto);
        if (createdincome!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdincome);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllIncomes(){
        return ResponseEntity.ok(incomeServices.getAllIncomes());
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateIncome(@PathVariable("id") Long id,@RequestBody IncomeDto incomeDto){
        try {
            return ResponseEntity.ok(incomeServices.updateIncome(id,incomeDto));
        }catch (EntityNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getIncomeById(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(incomeServices.getIncomeById(id));
        }catch (EntityNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteIncome(@PathVariable("id") Long id){
        try{
            incomeServices.deleteIncome(id);
            return ResponseEntity.ok(null);
        }catch (EntityNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

}
