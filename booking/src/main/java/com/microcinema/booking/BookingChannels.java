package com.microcinema.booking;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BookingChannels {
    String BOOKING_CINEMA_OUTPUT = "bookingCinema";
    String BOOKING_PAYMENTS_OUTPUT = "bookingPayments";
    String BOOKING_PAYMENTS_RESPONSE_INPUT = "bookingPaymentsResponse";

    @Output(BOOKING_CINEMA_OUTPUT)
    MessageChannel bookingCinemaOutput();

    @Output(BOOKING_PAYMENTS_OUTPUT)
    MessageChannel bookingPaymentsOutput();

    @Input(BOOKING_PAYMENTS_RESPONSE_INPUT)
    SubscribableChannel bookingPaymentsResponseInput();
}
