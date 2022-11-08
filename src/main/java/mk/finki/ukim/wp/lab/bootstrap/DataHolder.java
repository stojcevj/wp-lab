package mk.finki.ukim.wp.lab.bootstrap;

import mk.finki.ukim.wp.lab.model.Balloon;
import mk.finki.ukim.wp.lab.model.Manufacturer;
import mk.finki.ukim.wp.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    @PostConstruct
    public void init(){

        manufacturers.add(new Manufacturer("Nike", "Malaya", "Nike st. 25"));
        manufacturers.add(new Manufacturer("Adidas", "France", "Adidas st. 1"));
        manufacturers.add(new Manufacturer("Puma", "Macedonia", "Puma st. 3"));
        manufacturers.add(new Manufacturer("TNF", "Germany", "TNF st. 31"));
        manufacturers.add(new Manufacturer("Gucci", "Italy", "Gucci st. 12"));

        balloons.add(new Balloon("Red Balloon","Red Balloon", manufacturers.get(0)));
        balloons.add(new Balloon("Green Balloon","Green Balloon", manufacturers.get(1)));
        balloons.add(new Balloon("Yellow Balloon","Yellow Balloon", manufacturers.get(2)));
        balloons.add(new Balloon("Purple Balloon","Purple Balloon", manufacturers.get(3)));
        balloons.add(new Balloon("Pink Balloon","Pink Balloon", manufacturers.get(4)));
        balloons.add(new Balloon("White Balloon","White Balloon", manufacturers.get(2)));
        balloons.add(new Balloon("Black Balloon","Black Balloon", manufacturers.get(2)));
        balloons.add(new Balloon("Cyan Balloon","Cyan Balloon", manufacturers.get(3)));
        balloons.add(new Balloon("Gray Balloon","Gray Balloon", manufacturers.get(1)));
    }
}
