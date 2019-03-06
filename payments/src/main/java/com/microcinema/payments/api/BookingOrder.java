package com.microcinema.payments.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class BookingOrder {
    private Long clientId;
    private Long performanceId;
    private Set<BookingPlace> bookingPlaces = new HashSet<>();
}
