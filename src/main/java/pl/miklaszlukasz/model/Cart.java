package pl.miklaszlukasz.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by rogonion on 07.09.16.
 */
@Entity
public class Cart {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItem;

//    @OneToOne
//    @JoinColumn(name = "customerId")
//    private Customer customer;

    private BigDecimal totalPrice;

    public long getId() {
        return id;
    }

    public List<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
