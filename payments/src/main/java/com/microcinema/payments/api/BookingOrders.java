package com.microcinema.payments.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BookingOrders {
    public List<BookingOrder> orders;
}