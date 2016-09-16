package pl.miklaszlukasz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.miklaszlukasz.entities.Order;
import pl.miklaszlukasz.entities.Product;
import pl.miklaszlukasz.model.Cart;
import pl.miklaszlukasz.service.ProductService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rogonion on 07.09.16.
 */
@Controller
public class ProductListController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
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

    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public String getProductList(@ModelAttribute("model") ModelMap model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }
}
