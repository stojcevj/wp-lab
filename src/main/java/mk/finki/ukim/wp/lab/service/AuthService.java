package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.User;

import java.time.LocalDate;
import java.util.Optional;

public interface AuthService {
    Optional<User> login(String username, String password);
    User register(String username, String name, String surname, String password, LocalDate dateOfBirth);
}
