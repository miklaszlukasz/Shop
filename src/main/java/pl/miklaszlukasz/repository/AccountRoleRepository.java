package pl.miklaszlukasz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.miklaszlukasz.entities.AccountRole;

import java.util.List;

/**
 * Created by rogonion on 13.09.16.
 */
@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {
    List<String> findAccountRoleByUserName(String username);
}
