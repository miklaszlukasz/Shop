package pl.miklaszlukasz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miklaszlukasz.entities.Order;

import java.util.List;

/**
 * Created by rogonion on 08.09.16.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order save(Order order);

    List<Order> findAll();

    Order findOne(Long id);
}
