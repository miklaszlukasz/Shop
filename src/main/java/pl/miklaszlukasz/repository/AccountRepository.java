package pl.miklaszlukasz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.miklaszlukasz.model.Account;

/**
 * Created by rogonion on 08.09.16.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByLoginAndPassword(String login, String password);
}