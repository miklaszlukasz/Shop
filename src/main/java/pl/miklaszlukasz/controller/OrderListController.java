package pl.miklaszlukasz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.miklaszlukasz.entities.Order;
import pl.miklaszlukasz.service.OrderService;

import java.util.List;

/**
 * Created by rogonion on 16.09.16.
 */
@Controller
public class OrderListController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/orderList", method = RequestMethod.GET)
    public String getProductList(@ModelAttribute("model") ModelMap model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "orderList";
    }
}
