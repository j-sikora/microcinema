package com.microcinema.booking.api;

import com.microcinema.booking.BookingChannels;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@EnableBinding(BookingChannels.class)
public class Publisher {

//    @InboundChannelAdapter(channel = BookingChannels.BOOKING_PAYMENTS_OUTPUT, poller = @Poller(fixedDelay = "2000"))
//    public BookingOrders publishBookingPayments() {
//        System.out.println("publishBookingPayments");
//        List<BookingOrder> orders = new ArrayList<>();
//        Set<BookingPlace> places = new HashSet<>();
//        places.add(new BookingPlace("H", 22, new BigDecimal("15.00")));
//        places.add(new BookingPlace("H", 21, new BigDecimal("25.00")));
//        orders.add(new BookingOrder(1l, 1l, places));
////        synchronized (bookingOrderMap) {
////            bookingOrderMap.forEach((key, value) -> orders.add(value));
////            bookingOrderMap.clear();
////        }
////        if(orders.size() == 0) {
////            return null;
////        }
//
//        BookingOrders bookingOrders = new BookingOrders(orders);
//        System.out.println("Sending:" + bookingOrders);
////        return () -> MessageBuilder.withPayload(bookingOrders).build();
////        return new MessageSource<BookingOrders>() {
////            @Override
////            public Message<BookingOrders> receive() {
////                return null;
////            }
////        };
//        return bookingOrders;
//    }

//    @Bean
//    @InboundChannelAdapter(channel = BookingChannels.BOOKING_PAYMENTS_OUTPUT, poller = @Poller(fixedDelay = "2000"))
//    public MessageSource<BookingOrders> publishBookingPayments() {
//        System.out.println("publishBookingPayments");
//        List<BookingOrder> orders = new ArrayList<>();
//        Set<BookingPlace> places = new HashSet<>();
//        places.add(new BookingPlace("H", 22, new BigDecimal("15.00")));
//        places.add(new BookingPlace("H", 21, new BigDecimal("25.00")));
//        orders.add(new BookingOrder(1l, 1l, places));
//
//        BookingOrders bookingOrders = new BookingOrders(orders);
//        return () -> new GenericMessage<>(bookingOrders);
//    }
}
