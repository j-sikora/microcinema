package com.microcinema.movies.services;

import com.microcinema.movies.api.Movie;
import com.microcinema.movies.api.Movies;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class MoviesService {
    private Map<Long, Movie> movies = new HashMap<>();

    @PostConstruct
    private void initTest() {
        movies.put(1l, new Movie.Builder().id(1l)
                .title("Skazani na Shawshank")
                .genre(Movie.Genre.DRAMA)
                .minutesLength(142)
                .publishYear("1994")
                .build());
        movies.put(2l, new Movie.Builder().id(2l)
                .title("Gladiator")
                .genre(Movie.Genre.DRAMA)
                .genre(Movie.Genre.HISTORICAL)
                .minutesLength(153)
                .publishYear("2000")
                .build());
        movies.put(3l, new Movie.Builder().id(3l)
                .title("Matrix")
                .genre(Movie.Genre.ACTION)
                .genre(Movie.Genre.SCIENCE_FICTION)
                .minutesLength(140)
                .publishYear("1999")
                .build());
    }

    public Movie getMovie(Long id) {
        return movies.get(id);
    }

    public Movies getMovies() {
        return new Movies(movies.get(1l), movies.get(2l), movies.get(3l));
    }
}
