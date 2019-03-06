package com.microcinema.cinema;

import com.microcinema.cinema.api.Performances;
import com.microcinema.cinema.services.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CinemaRestController {
    private final PerformanceService performanceService;

    @Autowired
    public CinemaRestController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @RequestMapping("/performances")
    public Performances getPerformance() {
        return performanceService.getPerformances();
    }



}
