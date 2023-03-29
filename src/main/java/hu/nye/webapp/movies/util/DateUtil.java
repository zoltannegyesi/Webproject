package hu.nye.webapp.movies.util;

import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class DateUtil {

    public Date now() {
        return new Date();
    }

}
