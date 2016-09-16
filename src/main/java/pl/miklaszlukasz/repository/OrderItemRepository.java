package pl.miklaszlukasz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.miklaszlukasz.entities.OrderItem;

/**
 * Created by rogonion on 08.09.16.
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    OrderItem save(OrderItem boughtProduct);
    void delete(Long id);
}
