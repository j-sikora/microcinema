package com.microcinema.booking.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingPlace {
    private String row;
    private Integer column;
    private BigDecimal amount;
}
