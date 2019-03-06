package com.microcinema.booking;

import com.microcinema.booking.api.BookingOrder;
import com.microcinema.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingRestController {
    private final BookingService bookingService;

    @Autowired
    public BookingRestController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public Long createBooking(@RequestBody BookingOrder bookingOrder) {
        return bookingService.createBooking(bookingOrder);
    }
}
