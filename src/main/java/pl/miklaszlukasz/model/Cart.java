package pl.miklaszlukasz.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.miklaszlukasz.entities.Order;
import pl.miklaszlukasz.entities.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by rogonion on 15.09.16.
 */
@Component
@Scope(value="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable {

    private List<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public void addItemToCart(Product product, int amount) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().equals(product)) {
                cartItem.addAmount(amount);
                return;
            }
        }
        cartItems.add(new CartItem(product, amount));
    }

    public BigDecimal getPrice() {
        BigDecimal price = new BigDecimal("0");
        for (CartItem cartItem : cartItems)
            price = price.add(cartItem.getPrice());
        return price;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public Order returnAsOrder() {
        Order order = new Order();
        order.setPrice(getPrice());
        for (CartItem cartItem : cartItems)
            order.addOrderItems(cartItem.getAsOrderItem(order));
        order.setOrderDate(Calendar.getInstance().getTime());
        return order;
    }

    public void clear() {
        cartItems = new ArrayList<>();
    }
}
