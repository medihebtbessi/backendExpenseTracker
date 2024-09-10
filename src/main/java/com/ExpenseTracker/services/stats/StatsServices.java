package com.ExpenseTracker.services.stats;

import com.ExpenseTracker.dto.GraphDto;
import com.ExpenseTracker.dto.StatsDto;

public interface StatsServices {
    public GraphDto getChartData();
    public StatsDto getStats();
}
