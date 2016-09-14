package pl.miklaszlukasz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.miklaszlukasz.entities.BoughtProduct;

/**
 * Created by rogonion on 08.09.16.
 */
@Repository
public interface BoughtProductRepository extends JpaRepository<BoughtProduct, Long> {
    BoughtProduct save(BoughtProduct boughtProduct);
    void delete(Long id);
}
