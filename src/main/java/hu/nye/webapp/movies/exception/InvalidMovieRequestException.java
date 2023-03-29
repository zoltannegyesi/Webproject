package hu.nye.webapp.movies.exception;

import java.util.List;


public class InvalidMovieRequestException extends RuntimeException {

    private final List<String> errors;

    public InvalidMovieRequestException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

}
