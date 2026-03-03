package org.example.springboot.service;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Slf4j
public class EarlyBirdDiscountService {

    public String discount(LocalDate eventDate,LocalDate bookingDate) {
        log.info("Service:");
        log.info("Discount calculating...");

        if(eventDate == null || bookingDate == null) {
            return "Event date and booking date are required.";
        }
        long daysAhead = ChronoUnit.DAYS.between(bookingDate, eventDate);
        log.info("DaysAhead: {}", daysAhead);

        if(daysAhead < 0) {
            return "Event date cannot be before booking date.";
        }

        if(daysAhead >= 30) {
          return "15% Discount applied.";
        }

        return "No discount applied.Book at least 30 days early for 15% off";
    }
}
