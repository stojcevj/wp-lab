package mk.finki.ukim.wp.lab.repository.standard;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryBalloonRepository {

    public List<Balloon> findAllBalloons(){
        return DataHolder.balloons.stream().sorted(Comparator.comparing(Balloon::getName)).collect(Collectors.toList());
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloons.stream()
                .filter(s->s.getName().contains(text) || s.getDescription().contains(text))
                .collect(Collectors.toList());
    }

    public Optional<Balloon> saveBalloon(Balloon balloon){
        DataHolder.balloons.add(balloon);
        return Optional.of(balloon);
    }

    public Optional<Balloon> findById(Long id){
        return DataHolder.balloons.stream().filter(i->i.getId().equals(id)).findFirst();
    }

    public void deleteBalloon(Long id){
        DataHolder.balloons.removeIf(i->i.getId().equals(id));
    }
}
