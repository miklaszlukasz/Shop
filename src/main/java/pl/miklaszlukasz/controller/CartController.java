package pl.miklaszlukasz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.miklaszlukasz.model.Cart;
import pl.miklaszlukasz.service.OrderService;

import javax.inject.Inject;

/**
 * Created by rogonion on 13.09.16.
 */
@Controller
public class CartController {

    private Cart cart;
    private OrderService orderService;

    @Inject
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("cartItems", cart.getCartItems());
        model.addAttribute("totalPrice", cart.getPrice());
        return "cart";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public String submitOrder() {
        orderService.save(cart.returnAsOrder());
        cart.clear();
        return "redirect:/orderList";
    }
}