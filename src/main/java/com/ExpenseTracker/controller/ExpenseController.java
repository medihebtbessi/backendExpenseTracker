package com.ExpenseTracker.controller;

import com.ExpenseTracker.dto.ExpenseDto;
import com.ExpenseTracker.entity.Expense;
import com.ExpenseTracker.services.expense.ExpenseServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpenseController {
    private final ExpenseServices expenseServices;

    @PostMapping("/add")
    public ResponseEntity<?> postExpense(@RequestBody ExpenseDto dto){
        Expense createdExpense=expenseServices.postExpense(dto);
        if (createdExpense!=null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllExpenses(){
        return ResponseEntity.ok(expenseServices.getAllExpenses());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getExpenseById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(expenseServices.getExpenseById(id));
        }catch (EntityNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable Long id,@RequestBody ExpenseDto expenseDto){
        try {
            return ResponseEntity.ok(expenseServices.updateExpense(id,expenseDto));
        }catch (EntityNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable("id") Long id){
        try {
            expenseServices.deleteExpense(id);
            return ResponseEntity.ok(null);
        }catch (EntityNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
