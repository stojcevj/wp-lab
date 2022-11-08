package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    Optional<Balloon> findById(Long id);
    Optional<Balloon> save(String name, String description, Long manufacturer, Long id);
    void deleteBalloon(Long id);
}
