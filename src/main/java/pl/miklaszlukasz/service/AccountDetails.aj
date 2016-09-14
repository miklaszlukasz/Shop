package pl.miklaszlukasz.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import pl.miklaszlukasz.entities.Account;

import java.util.Collection;
import java.util.List;

/**
 * Created by rogonion on 14.09.16.
 */
public class AccountDetails extends Account implements UserDetails {
    private static final long serialVersionUID = 1L;
    private List<String> accountRoles;

    public AccountDetails(Account account, List<String> accountRoles){
        super(account);
        this.accountRoles = accountRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        String roles= StringUtils.collectionToCommaDelimitedString(accountRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String getUsername() {
        return super.getLogin();
    }
}
