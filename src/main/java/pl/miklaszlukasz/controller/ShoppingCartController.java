package pl.miklaszlukasz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.miklaszlukasz.entities.BoughtProduct;
import pl.miklaszlukasz.service.CartService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by rogonion on 13.09.16.
 */
@Controller
@SessionAttributes("cart")
public class ShoppingCartController {

    private CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/product_{id}", method = RequestMethod.POST)
    public String addProductToCart(@PathVariable(value = "id") int id, ModelMap modelMap, HttpSession httpSession) {
        //modelMap.put("listProducts", )
        return "product";
    }
}
