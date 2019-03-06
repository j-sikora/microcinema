package com.microcinema.cinema.api;

import lombok.Data;

import java.util.Set;
import java.util.TreeSet;

@Data
public class Movies {
    Set<Movie> movies = new TreeSet<>();

    public Movies(Movie...movies) {
        for (Movie movie : movies) {
            this.movies.add(movie);
        }
    }
}
