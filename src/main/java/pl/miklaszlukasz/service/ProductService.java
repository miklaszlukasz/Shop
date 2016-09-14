package pl.miklaszlukasz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.miklaszlukasz.entities.Product;
import pl.miklaszlukasz.repository.ProductRepository;

import java.util.List;

/**
 * Created by rogonion on 08.09.16.
 */
@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void createNewProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        productRepository.updateById(product.getId(), product.getName(), product.getPrice(), product.getDescription());
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
