package pl.miklaszlukasz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.miklaszlukasz.entities.Product;

import java.util.ArrayList;

/**
 * Created by rogonion on 08.09.16.
 */
@Controller
@SessionAttributes({"cart"})
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        if(!model.containsAttribute("cart")) {
            model.addAttribute("cart", new ArrayList<Product>());
        }
        return "home";
    }
}
