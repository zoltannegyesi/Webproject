package hu.nye.webapp.movies.repository;

import hu.nye.webapp.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {
}
