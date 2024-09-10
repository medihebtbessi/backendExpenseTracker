package com.ExpenseTracker.controller;

import com.ExpenseTracker.dto.GraphDto;
import com.ExpenseTracker.services.stats.StatsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {
    private final StatsServices statsServices;
    @GetMapping("/chart")
    public ResponseEntity<GraphDto> getChartDetails(){
        return ResponseEntity.ok(statsServices.getChartData());
    }

    @GetMapping()
    public ResponseEntity<?> getStats(){
        return ResponseEntity.ok(statsServices.getStats());
    }
}
