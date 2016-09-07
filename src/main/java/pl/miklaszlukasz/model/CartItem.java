package pl.miklaszlukasz.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * Created by rogonion on 07.09.16.
 */
@Entity
public class CartItem {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Min(value = 1, message = "You can buy more than 1 product")
    private int amount;
    @Min(value = 0, message = "Price cant be less than 0")
    private BigDecimal totalPrice;

    public long getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
