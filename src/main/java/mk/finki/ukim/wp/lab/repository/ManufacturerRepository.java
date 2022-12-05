package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {
    public List<Manufacturer> findAll(){
        return DataHolder.manufacturers.stream().toList();
    }

    public Optional<Manufacturer> findById(Long id){
        return DataHolder.manufacturers.stream().filter(i->i.getId().equals(id)).findFirst();
    }
}
