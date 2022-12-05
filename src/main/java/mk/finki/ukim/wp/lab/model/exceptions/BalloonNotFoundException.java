package mk.finki.ukim.wp.lab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BalloonNotFoundException extends RuntimeException{
    public BalloonNotFoundException(Long id) {
        super("Balloon with id=" + id + " is not found");
    }
}
