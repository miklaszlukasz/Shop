package pl.miklaszlukasz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.miklaszlukasz.entities.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by rogonion on 07.09.16.
 */
@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(Long id);

    List<Product> findAll();

    Product save(Product product);

    void delete(Product product);

    @Modifying
    @Query(value = "UPDATE Product p set p.name=:name, p.price =:price, p.description =:description WHERE p.id =:id")
    void updateById(@Param("id") Long id,
                    @Param("name") String name,
                    @Param("price") BigDecimal price,
                    @Param("description") String description);
}

