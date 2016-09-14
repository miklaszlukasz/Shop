package pl.miklaszlukasz.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by rogonion on 08.09.16.
 */
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
    @Id
    private String login;
    private String password;

    public Account(){

    }

    public Account(Account account) {
        this.password = account.login;
        this.password = account.password;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
