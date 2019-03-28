package com.microcinema.cinema;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface CinemaChannels {
    String BOOKING_CINEMA_INPUT = "bookingCinema";
    String CINEMA_REPORT_TASK_OUTPUT = "cinemaReportTask";

    @Input(BOOKING_CINEMA_INPUT)
    SubscribableChannel bookingCinemaInput();

    @Output(CINEMA_REPORT_TASK_OUTPUT)
    MessageChannel cinemaReportTaskOutput();
}
