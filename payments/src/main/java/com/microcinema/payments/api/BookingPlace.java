package com.microcinema.payments.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class BookingPlace {
    private String row;
    private Integer column;
    private BigDecimal amount;
}
