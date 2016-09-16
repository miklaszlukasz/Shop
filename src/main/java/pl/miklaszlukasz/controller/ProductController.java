package pl.miklaszlukasz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miklaszlukasz.entities.Product;
import pl.miklaszlukasz.model.Cart;
import pl.miklaszlukasz.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rogonion on 15.09.16.
 */
@Controller
public class ProductController {
    private ProductService productService;
    private Cart cart;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping(value = "/product_{id}", method = RequestMethod.GET)
    public String getProduct(Model model, @PathVariable("id") long id) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(value = "/product_{id}", method = RequestMethod.POST)
    public String addProductToCart(@PathVariable("id") long id, HttpServletRequest request) {
        final int amount = Integer.valueOf(request.getParameter("amount"));
        cart.addItemToCart(productService.getProduct(id), amount);
        return "redirect:/cart";
    }
}
