package com.microcinema.payments;

import com.microcinema.payments.api.BookingOrder;
import com.microcinema.payments.api.BookingOrders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.List;

@EnableBinding(PaymentsChannels.class)
public class BookingListener {

    @StreamListener(PaymentsChannels.BOOKING_PAYMENTS_INPUT)
    @SendTo(PaymentsChannels.BOOKING_PAYMENTS_RESPONSE_OUTPUT)
    public String receive(BookingOrders bookings) {
        System.out.println("Booking received=" + bookings);
        List<BookingOrder> orders = bookings.getOrders();
        System.out.println("Booking received=" + orders.size());
        orders.forEach((order) -> System.out.println(order.toString()));
        return "Orders processed=" + orders.size();
    }

}