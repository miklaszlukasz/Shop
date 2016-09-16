package pl.miklaszlukasz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.miklaszlukasz.repository.OrderItemRepository;

/**
 * Created by rogonion on 12.09.16.
 */
@Service
@SessionAttributes("cart")
public class OrderItemService {

    OrderItemRepository orderItemRepository;

    @Autowired
    public void setOrderItemRepository(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }
}
