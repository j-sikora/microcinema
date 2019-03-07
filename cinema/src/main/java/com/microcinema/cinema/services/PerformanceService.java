package com.microcinema.cinema.services;

import com.microcinema.cinema.api.Movie;
import com.microcinema.cinema.api.Performance;
import com.microcinema.cinema.api.Performances;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@RefreshScope
public class PerformanceService {

    private final RestTemplate restTemplate;
    private final Map<Long, Performance> performanceMap = new HashMap<>();

    @Value("${cinema.advertisementTime}")
    private Integer advertisementTime;

    @Autowired
    public PerformanceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @PostConstruct
    private void initTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 18 + 1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        performanceMap.put(1l, new Performance.Builder().id(1l)
                .movieId(2l)
                .room(1)
                .startDate(calendar.getTime())
                .build());
        performanceMap.put(2l, new Performance.Builder().id(1l)
                .movieId(2l)
                .room(2)
                .startDate(calendar.getTime())
                .build());
        calendar.set(Calendar.HOUR_OF_DAY, 20 + 1);

        performanceMap.put(3l, new Performance.Builder().id(1l)
                .movieId(3l)
                .room(3)
                .startDate(calendar.getTime())
                .build());
        performanceMap.put(4l, new Performance.Builder().id(1l)
                .movieId(1l)
                .room(4)
                .startDate(calendar.getTime())
                .build());
    }

    public void calculatePerformanceEnd(Performance performance, Integer movieLength) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(performance.getStartDate());
        calendar.add(Calendar.MINUTE, movieLength);
        calendar.add(Calendar.MINUTE, advertisementTime);
        performance.setEndDate(calendar.getTime());
    }

    @HystrixCommand(fallbackMethod = "getPerformanceFallback")
    public Performances getPerformances() {
        final Performances performances = new Performances();
        final Map<Long, Movie> movies = new HashMap<>();
        performanceMap.forEach((performanceId, performance) -> {
            Long movieId = performance.getMovieId();
            Movie movie;
            if (!movies.containsKey(movieId)) {
                movie = restTemplate.getForObject("http://movies-service/movie/" + movieId, Movie.class);
                performances.getMovies().add(movie);
                movies.put(movieId, movie);
            } else {
                movie = movies.get(movieId);
            }
            calculatePerformanceEnd(performance, movie.getMinutesLength());
            performances.addPerformance(performance);
        });
        return performances;
    }

    public Performances getPerformanceFallback() {
        return new Performances(performanceMap.values());
    }
}