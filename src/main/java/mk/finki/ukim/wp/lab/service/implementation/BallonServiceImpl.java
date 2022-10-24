package mk.finki.ukim.wp.lab.service.implementation;

import mk.finki.ukim.wp.lab.model.Balloon;
import mk.finki.ukim.wp.lab.repository.BalloonRepository;
import mk.finki.ukim.wp.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BallonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;

    public BallonServiceImpl(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        if(text.isEmpty()){
            return null;
        }

        return balloonRepository.findAllByNameOrDescription(text);
    }
}
