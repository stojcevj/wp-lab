package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    public List<Order> listOrders(){
        return DataHolder.orders;
    }

    public Order addOrder(Order o){
        if(o != null){
            DataHolder.orders.add(o);
            return o;
        }
        return null;
    }
}
