package com.microcinema.cinema;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;

//@EnableBinding(Sink.class)
//@EnableBinding(Processor.class)
@EnableBinding(CinemaChannels.class)
public class BookingReceiver {

    @StreamListener(CinemaChannels.BOOKING_CINEMA_INPUT)
    @ServiceActivator(inputChannel = CinemaChannels.BOOKING_CINEMA_INPUT)
    public void receive(String msg) {
        System.out.println("Booking received=" + msg);
    }

//    @StreamListener(Processor.INPUT)
//    @SendTo(Processor.OUTPUT)
//    public String receive(String msg) {
//        System.out.println("received=" + msg);
//        return msg;
//    }

//    @StreamListener(value = Sink.INPUT, condition = "header['speed'] >  40")
//    @ServiceActivator(inputChannel = Sink.INPUT)
//    public void logFast(String msg) {
//        System.out.println("fast=" + msg);
//    }
//
//    @StreamListener(value = Sink.INPUT, condition = "header['speed'] <=  40")
//    @ServiceActivator(inputChannel = Sink.INPUT)
//    public void logSlow(String msg) {
//        System.out.println("slow=" + msg);
//    }
}
