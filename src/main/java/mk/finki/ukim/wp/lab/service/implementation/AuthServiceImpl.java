package mk.finki.ukim.wp.lab.service.implementation;

import mk.finki.ukim.wp.lab.model.User;
import mk.finki.ukim.wp.lab.repository.jpa.AuthRepository;
import mk.finki.ukim.wp.lab.service.AuthService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;

    public AuthServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public Optional<User> login(String username, String password) {
        return authRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User register(String username, String name, String surname, String password, LocalDate dateOfBirth) {
        User tmp = new User(username, name, surname, password, dateOfBirth);
        return authRepository.save(tmp);
    }
}
