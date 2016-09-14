package pl.miklaszlukasz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.miklaszlukasz.entities.Product;
import pl.miklaszlukasz.service.ProductService;

import java.util.List;

/**
 * Created by rogonion on 07.09.16.
 */
@Controller
public class ProductsController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

//    @PostConstruct
//    public void generateItems() {
//        final double MIN_PRICE = 130.0;
//        final double MAX_PRICE = 550.0;
//
//        for (int i = 0; i < 100; i++) {
//            Product product = new Product();
//            String someString = new SimpleDateFormat().format(Calendar.getInstance().getTime());
//            product.setName(someString);
//            double price = ThreadLocalRandom.current().nextDouble(MIN_PRICE, MAX_PRICE);
//            product.setPrice(new BigDecimal(price));
//            product.setDescription(someString);
//            productService.createNewProduct(product);
//        }
//    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProductList(@ModelAttribute("model") ModelMap model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return products;
    }

    @RequestMapping(value = "/product_{id}", method = RequestMethod.GET)
    public String getProduct(Model model, @PathVariable("id") long id) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(value = "/createNewProduct", method = RequestMethod.GET)
    public String newProduct() {
        return "createNewProduct";
    }

    @RequestMapping(value = "/createNewProduct", method = RequestMethod.POST)
    public String createNewProduct(@ModelAttribute("product") Product product) {
        productService.createNewProduct(product);
        return "redirect:/createNewProduct";
    }
}
