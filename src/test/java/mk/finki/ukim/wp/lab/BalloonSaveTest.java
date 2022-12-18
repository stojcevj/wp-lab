package mk.finki.ukim.wp.lab;

import mk.finki.ukim.wp.lab.model.Balloon;
import mk.finki.ukim.wp.lab.model.Manufacturer;
import mk.finki.ukim.wp.lab.model.exceptions.ManufacturerNotFoundException;
import mk.finki.ukim.wp.lab.repository.jpa.BalloonRepository;
import mk.finki.ukim.wp.lab.repository.jpa.ManufacturerRepository;
import mk.finki.ukim.wp.lab.service.implementation.BalloonServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)

public class BalloonSaveTest {

    @Mock
    private BalloonRepository balloonRepository;

    @Mock
    private ManufacturerRepository manufacturerRepository;

    private BalloonServiceImpl balloonService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        Manufacturer m = new Manufacturer("nike","macedonia","skopje");
        Balloon balloon = new Balloon("balon","desk", m);

        Mockito.when(this.balloonRepository.save(Mockito.any(Balloon.class))).thenReturn(balloon);
        Mockito.when(this.manufacturerRepository.findById(Mockito.any())).thenReturn(java.util.Optional.of(m));

        balloonService = Mockito.spy(new BalloonServiceImpl(this.balloonRepository, this.manufacturerRepository));
    }

    @Test
    public void testSuccessfullAdd(){
        Optional<Balloon> b = this.balloonService.save("nike","asd",3L,5L);
        Mockito.verify(this.balloonService).save("nike","asd",3L,5L);
        Assert.assertNotNull("null balloon", b.get());
    }

    @Test
    public void testExceptionAdd(){
        Assert.assertThrows("ManufacturerNotFoundException expected", ManufacturerNotFoundException.class,
                ()-> this.balloonService.save("nike","asd",null,5L));
        Mockito.verify(this.balloonService).save("nike","asd",null,5L);
    }
}
