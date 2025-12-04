package com.gameflix.auth.service;

import com.gameflix.auth.model.Movie;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public MovieService() {
        movies.add(new Movie(1L, "Interstellar", "Sci-Fi", 4.8));
        movies.add(new Movie(2L, "Inception", "Sci-Fi", 4.7));
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(Long id) {
        return movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addMovie(Movie movie) {
        if (movie.getId() == null) {
            long nextId = movies.stream()
                    .mapToLong(Movie::getId)
                    .max()
                    .orElse(0L) + 1L;
            movie.setId(nextId);
        }
        movies.add(movie);
    }
}
