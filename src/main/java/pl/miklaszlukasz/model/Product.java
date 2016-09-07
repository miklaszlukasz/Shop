package pl.miklaszlukasz.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * Created by rogonion on 07.09.16.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue()
    private long id;
    @NotEmpty(message = "The product name must not be empty")
    private String name;
    @Min(value = 0, message = "The product price must not be less then 0")
    private BigDecimal price;
    @Min(value = 0, message = "The product enable amount must not be less then 0")
    private int avaibleAmount;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAvaibleAmount() {
        return avaibleAmount;
    }

    public void setAvaibleAmount(int avaibleAmount) {
        this.avaibleAmount = avaibleAmount;
    }
}
