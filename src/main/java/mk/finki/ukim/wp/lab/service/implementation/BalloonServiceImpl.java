package mk.finki.ukim.wp.lab.service.implementation;

import mk.finki.ukim.wp.lab.model.Balloon;
import mk.finki.ukim.wp.lab.model.Manufacturer;
import mk.finki.ukim.wp.lab.model.exceptions.ManufacturerNotFoundException;
import mk.finki.ukim.wp.lab.repository.BalloonRepository;
import mk.finki.ukim.wp.lab.repository.ManufacturerRepository;
import mk.finki.ukim.wp.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
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

        return balloonRepository.findAllByNameOrDescription(text).stream().toList();
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonRepository.findById(id);
    }

    @Override
    public Optional<Balloon> save(String name, String description, Long manufacturer, Long id) {
        Manufacturer m = manufacturerRepository.findById(manufacturer).orElseThrow(()->new ManufacturerNotFoundException(manufacturer));
        Balloon balloon = new Balloon(name, description, m);
        balloonRepository.deleteBalloon(id);
        return balloonRepository.saveBalloon(balloon);
    }

    @Override
    public void deleteBalloon(Long id) {
        balloonRepository.deleteBalloon(id);
    }

}
