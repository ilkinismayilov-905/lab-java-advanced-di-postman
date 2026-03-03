package org.example.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springboot.service.EarlyBirdDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/discount")
@Slf4j
public class DiscountController {

    private EarlyBirdDiscountService earlyBirdDiscountService;

    public DiscountController(EarlyBirdDiscountService earlyBirdDiscountService) {
        this.earlyBirdDiscountService = earlyBirdDiscountService;
    }

    @GetMapping()
    public String discount(@RequestParam LocalDate eventDate,
                           @RequestParam LocalDate bookingDate) {
        log.info("Controller: Request discount calculating...");
        if(earlyBirdDiscountService == null){
            return "EarlyBird discount is not available.";
        }
        return earlyBirdDiscountService.discount(eventDate, bookingDate);
    }
}
