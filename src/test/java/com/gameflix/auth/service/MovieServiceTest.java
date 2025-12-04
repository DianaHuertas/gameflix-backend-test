package com.gameflix.auth.service;

import com.gameflix.auth.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllMovies_ShouldReturnList() {
        List<Movie> movies = movieService.getAllMovies();
        Assertions.assertNotNull(movies);
        Assertions.assertFalse(movies.isEmpty());
    }

    @Test
    void getMovieById_ShouldReturnMovie() {
        Movie movie = movieService.getMovieById(1L);
        Assertions.assertNotNull(movie);
        Assertions.assertEquals(1L, movie.getId());
    }

    @Test
    void addMovie_ShouldIncreaseListSize() {
        int before = movieService.getAllMovies().size();

        Movie m = new Movie();
        m.setTitle("Test");
        m.setGenre("Drama");
        m.setRating(4.0);

        movieService.addMovie(m);

        int after = movieService.getAllMovies().size();
        Assertions.assertEquals(before + 1, after);
    }
}
