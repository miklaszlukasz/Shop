package pl.miklaszlukasz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.miklaszlukasz.model.Account;
import pl.miklaszlukasz.repository.AccountRepository;

/**
 * Created by rogonion on 08.09.16.
 */
@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void login(String login, String password) {
        Account account = accountRepository.findByLoginAndPassword(login, password);
        account.setActive(true);
    }

    public void logout(Account account) {
        account.setActive(false);
    }


}
