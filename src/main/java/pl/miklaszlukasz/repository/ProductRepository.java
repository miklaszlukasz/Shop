package pl.miklaszlukasz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.miklaszlukasz.model.Product;

import java.util.List;

/**
 * Created by rogonion on 07.09.16.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Product findById(long id);
    Product save(Product product);
//    @Transactional
//    @Modifying
//    @Query("update Product p set p.name = :name, p.price = :price, p.avaibleAmount = :avaibleAmount where p.id = :id")
//    int setProductInfoById(@Param("name") String name,@Param("price") BigDecimal price,@Param("avaibleAmount") int enableAmount,@Param("id") long id);
}

