package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Balloon;

import java.util.List;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
}
