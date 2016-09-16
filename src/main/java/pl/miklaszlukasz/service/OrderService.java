package pl.miklaszlukasz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.miklaszlukasz.entities.Order;
import pl.miklaszlukasz.repository.OrderRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by rogonion on 08.09.16.
 */

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
