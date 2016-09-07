package pl.miklaszlukasz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miklaszlukasz.model.CartItem;

import java.util.List;

/**
 * Created by rogonion on 07.09.16.
 */
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByCartId(long id);

}
