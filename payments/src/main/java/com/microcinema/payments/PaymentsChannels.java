package com.microcinema.payments;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PaymentsChannels {
    String BOOKING_PAYMENTS_INPUT = "bookingPayments";
    String BOOKING_PAYMENTS_RESPONSE_OUTPUT = "bookingPaymentsResponse";

    @Input(BOOKING_PAYMENTS_INPUT)
    SubscribableChannel bookingPaymentsInput();

    @Output(BOOKING_PAYMENTS_RESPONSE_OUTPUT)
    MessageChannel bookingPaymentsOutput();

}
