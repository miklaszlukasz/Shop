package pl.miklaszlukasz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import pl.miklaszlukasz.model.Product;
import pl.miklaszlukasz.service.ProductService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rogonion on 07.09.16.
 */
@RestController
@Component
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void generateItems() {
        final double MIN_PRICE = 130.0;
        final double MAX_PRICE = 550.0;

        for (int i = 0; i < 100; i++) {
            Product product = new Product();
            String someString = new SimpleDateFormat().format(Calendar.getInstance().getTime());
            product.setName(someString);
            double price = ThreadLocalRandom.current().nextDouble(MIN_PRICE, MAX_PRICE);
            product.setPrice(new BigDecimal(price));
            product.setDescription(someString);
            productService.createNewProduct(product);
        }
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProductList() {
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @RequestMapping(value = "/product_{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }
}
