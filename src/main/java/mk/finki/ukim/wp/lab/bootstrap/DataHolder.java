package mk.finki.ukim.wp.lab.bootstrap;

import mk.finki.ukim.wp.lab.model.Balloon;
import mk.finki.ukim.wp.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    @PostConstruct
    public void init(){
        balloons.add(new Balloon("Red Balloon","Red Balloon"));
        balloons.add(new Balloon("Green Balloon","Green Balloon"));
        balloons.add(new Balloon("Yellow Balloon","Yellow Balloon"));
        balloons.add(new Balloon("Purple Balloon","Purple Balloon"));
        balloons.add(new Balloon("Pink Balloon","Pink Balloon"));
        balloons.add(new Balloon("White Balloon","White Balloon"));
        balloons.add(new Balloon("Black Balloon","Black Balloon"));
        balloons.add(new Balloon("Cyan Balloon","Cyan Balloon"));
        balloons.add(new Balloon("Gray Balloon","Gray Balloon"));
    }
}
