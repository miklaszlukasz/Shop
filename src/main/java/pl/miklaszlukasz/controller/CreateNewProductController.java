package pl.miklaszlukasz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.miklaszlukasz.entities.Product;
import pl.miklaszlukasz.service.ProductService;

/**
 * Created by rogonion on 15.09.16.
 */
@Controller
public class CreateNewProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/createNewProduct", method = RequestMethod.GET)
    public String newProduct() {
        return "createNewProduct";
    }

    @RequestMapping(value = "/createNewProduct", method = RequestMethod.POST)
    public String createNewProduct(@ModelAttribute("product") Product product) {
        productService.createNewProduct(product);
        return "redirect:/productList";
    }
}
