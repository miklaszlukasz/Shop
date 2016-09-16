package pl.miklaszlukasz.model;

import pl.miklaszlukasz.entities.Order;
import pl.miklaszlukasz.entities.OrderItem;
import pl.miklaszlukasz.entities.Product;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by rogonion on 15.09.16.
 */
public class CartItem implements Serializable {
    private Product product;
    private int amount;

    public CartItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public CartItem() {
    }

    public Product getProduct()  {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(int amount) {
        this.amount+=amount;
    }

    public BigDecimal getPrice() {
        return product.getPrice().multiply(BigDecimal.valueOf(amount));
    }

    public OrderItem getAsOrderItem(Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setAmount(amount);
        return orderItem;
    }
}
