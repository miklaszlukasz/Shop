package pl.miklaszlukasz.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rogonion on 08.09.16.
 */

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private Date orderDate;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    private BigDecimal price;

//    private String customerName;
//    private String customerAddress;
//    private String customerEmail;
//    private String customerPhone;

    public Order() {
        orderItems = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItems(OrderItem orderItems) {
        this.orderItems.add(orderItems);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getCustomerAddress() {
//        return customerAddress;
//    }
//
//    public void setCustomerAddress(String customerAddress) {
//        this.customerAddress = customerAddress;
//    }
//
//    public String getCustomerEmail() {
//        return customerEmail;
//    }
//
//    public void setCustomerEmail(String customerEmail) {
//        this.customerEmail = customerEmail;
//    }
//
//    public String getCustomerPhone() {
//        return customerPhone;
//    }
//
//    public void setCustomerPhone(String customerPhone) {
//        this.customerPhone = customerPhone;
//    }
}