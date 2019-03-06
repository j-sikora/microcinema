package com.microcinema.booking.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingOrder {
    private Long id;
    private Long clientId;
    private Long performanceId;
    private Set<BookingPlace> bookingPlaces = new HashSet<>();
}
