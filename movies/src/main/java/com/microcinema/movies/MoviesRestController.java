package com.microcinema.movies;


import com.microcinema.movies.api.Movie;
import com.microcinema.movies.api.Movies;
import com.microcinema.movies.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
public class MoviesRestController {

    private final MoviesService moviesService;

    @Autowired
    public MoviesRestController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @RequestMapping("/movie/{movieId}")
    public Movie getMovie(@PathVariable("movieId") Long id) {
        return moviesService.getMovie(id);
    }

    @RequestMapping("/movies")
    public Movies getMovies() {
        return moviesService.getMovies();
    }
}
