package mk.finki.ukim.wp.lab.model.exceptions;

import mk.finki.ukim.wp.lab.model.Manufacturer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ManufacturerNotFoundException extends RuntimeException{
    public ManufacturerNotFoundException(Long id){
        super("Manufacturer with id=" + id + " is not found");
    }
}
