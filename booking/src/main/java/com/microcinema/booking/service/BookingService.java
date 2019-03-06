package com.microcinema.booking.service;

import com.microcinema.booking.BookingChannels;
import com.microcinema.booking.api.BookingOrder;
import com.microcinema.booking.api.BookingOrders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@EnableBinding(BookingChannels.class)
public class BookingService {
    private final BookingChannels source;
    private BlockingQueue<BookingOrder> queue = new LinkedBlockingQueue<>(1000);
    private AtomicLong seq = new AtomicLong(0);

    @Autowired
    public BookingService(BookingChannels source) {
        this.source = source;
    }

    public Long createBooking(BookingOrder bookingOrder) {
        Long id = seq.incrementAndGet();
        bookingOrder.setId(id);
        source.bookingCinemaOutput().send(MessageBuilder.withPayload(bookingOrder).build());
        queue.add(bookingOrder);
        return id;
    }


    @InboundChannelAdapter(channel = BookingChannels.BOOKING_PAYMENTS_OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public BookingOrders publishBookingPayments() {
        log.info("checking ");
        List<BookingOrder> orders = new ArrayList<>();
        int count = queue.drainTo(orders, 100);
        log.info("Orders from queue count: " + count);
        return new BookingOrders(orders);
    }

    @StreamListener(BookingChannels.BOOKING_PAYMENTS_RESPONSE_INPUT)
    public void receive(String response) {
        log.info("response=" + response);
    }

}
