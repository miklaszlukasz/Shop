package pl.miklaszlukasz.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.miklaszlukasz.entities.Account;
import pl.miklaszlukasz.repository.AccountRepository;
import pl.miklaszlukasz.repository.AccountRoleRepository;

import java.util.List;

/**
 * Created by rogonion on 13.09.16.
 */
@Service
@ComponentScan
public class AccountService implements UserDetailsService {

    private AccountRepository accountRepository;
    private AccountRoleRepository accountRoleRepository;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    private void setAccountRoleRepository(AccountRoleRepository accountRoleRepository) {
        this.accountRoleRepository = accountRoleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByLogin(username);
        if (account == null)
            throw new UsernameNotFoundException("No account in database with login " + username);
        List<String> userRoles=accountRoleRepository.findAccountRoleByUserName(username);
        return new pl.miklaszlukasz.service.AccountDetails(account,userRoles);
    }
}
