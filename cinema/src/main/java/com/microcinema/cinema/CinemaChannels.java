package com.microcinema.cinema;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CinemaChannels {
    String BOOKING_CINEMA_INPUT = "bookingCinema";

    @Input(BOOKING_CINEMA_INPUT)
    SubscribableChannel bookingCinemaInput();

//    String BOOKING_CINEMA_INPUT = "bookingCinema";
//
//    @Input(BOOKING_CINEMA_INPUT)
//    SubscribableChannel bookingCinemaChannel();
}
