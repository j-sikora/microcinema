package com.microcinema.cinema.services;

import com.microcinema.cinema.CinemaChannels;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ReportService {
    public static final String GROUP_ID = "com.microcinema";
    public static final String ARTIFACT_ID = "cinema-report-task";
    public static final String EXT = "jar";
    public static final String VERSION = "0.0.1-SNAPSHOT";

    private static final String URL = "maven://" + GROUP_ID + ":" + ARTIFACT_ID + ":" + EXT + ":" + VERSION;

    private CinemaChannels cinemaChannels;

    @Autowired
    public ReportService(CinemaChannels cinemaChannels) {
        this.cinemaChannels = cinemaChannels;
    }

    @Scheduled(fixedDelay = 36000)
    public void startReport() {
        log.info("preparing report");
        Random random = new Random();
        List<String> input = new LinkedList<>();
        for (int i = 0; i <= random.nextInt(10); i++) {
            input.add(RandomStringUtils.randomAlphabetic(10));
        }
        log.info("Prepared input: " + input.toString());
        TaskLaunchRequest taskLaunchRequest = new TaskLaunchRequest(URL, input, null, null, null);

        GenericMessage<TaskLaunchRequest> genericMessage = new GenericMessage<>(taskLaunchRequest);
        cinemaChannels.cinemaReportTaskOutput().send(genericMessage);

    }
}
