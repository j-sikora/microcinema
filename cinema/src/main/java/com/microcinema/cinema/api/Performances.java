package com.microcinema.cinema.api;

import lombok.Data;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

@Data
public class Performances {
    private Set<Performance> performances = new LinkedHashSet<>();
    private Set<Movie> movies = new TreeSet<>(Comparator.comparingLong(Movie::getId));

    public void addPerformance(Performance performance) {
        performances.add(performance);
    }
}
