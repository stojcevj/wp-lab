package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {

    public List<Balloon> findAllBalloons(){
        return DataHolder.balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloons.stream()
                .filter(s->s.getName().contains(text) || s.getDescription().contains(text))
                .collect(Collectors.toList());
    }
}
