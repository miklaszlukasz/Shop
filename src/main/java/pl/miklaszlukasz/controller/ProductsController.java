package pl.miklaszlukasz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.miklaszlukasz.model.Product;
import pl.miklaszlukasz.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rogonion on 07.09.16.
 */
@RestController
@Component
public class ProductsController {

    private ProductRepository productRepository;

    @Autowired
    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void generateItems() {
        final double MIN_PRICE = 130.0;
        final double MAX_PRICE = 550.0;
        final int MIN_AVAIBLE_AMOUNT = 1;
        final int MAX_AVAIBLE_AMOUNT = 12;

        for (int i = 0; i < 100; i++) {
            Product product = new Product();
            product.setName(new SimpleDateFormat().format(Calendar.getInstance().getTime()));
            double price = ThreadLocalRandom.current().nextDouble(MIN_PRICE, MAX_PRICE);
            product.setPrice(new BigDecimal(price));
            int avaibleAmount = ThreadLocalRandom.current().nextInt(MIN_AVAIBLE_AMOUNT, MAX_AVAIBLE_AMOUNT);
            product.setAvaibleAmount(avaibleAmount);
            productRepository.save(product);
        }
    }

    @RequestMapping("/productList/all")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
