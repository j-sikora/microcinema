package com.microcinema.movies.api;

import lombok.Data;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Data
public class Movies {
    Set<Movie> movies = new TreeSet(Comparator.comparing(Movie::getTitle));

    public Movies(Movie...movies) {
        for (Movie movie : movies) {
            this.movies.add(movie);
        }
    }

}
