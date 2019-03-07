package com.microcinema.cinema.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class Performances {
    private Set<Performance> performances = new LinkedHashSet<>();
    private Set<Movie> movies = new TreeSet<>(Comparator.comparingLong(Movie::getId));

    public void addPerformance(Performance performance) {
        performances.add(performance);
    }

    public Performances(Collection<Performance> performances) {
        this.performances.addAll(performances);
    }
}
