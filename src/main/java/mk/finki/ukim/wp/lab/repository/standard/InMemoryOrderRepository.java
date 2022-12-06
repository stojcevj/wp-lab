package mk.finki.ukim.wp.lab.repository.standard;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Balloon;
import mk.finki.ukim.wp.lab.model.Order;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryOrderRepository {

    public List<Order> listOrders(){
        return DataHolder.orders;
    }

    public Optional<Order> addOrder(Order o){
        DataHolder.orders.add(o);
        return Optional.of(o);
    }

    public Optional<Order> getOrderById(Long id){
        return DataHolder.orders.stream().filter(i->i.getOrderId().equals(id)).findFirst();
    }

    public void deleteOrder(Long id){
        DataHolder.orders.removeIf(i->i.getOrderId().equals(id));
    }
}
