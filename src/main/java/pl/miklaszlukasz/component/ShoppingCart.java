package pl.miklaszlukasz.component;

/**
 * Created by rogonion on 12.09.16.
 */

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope(value = "session")
public class ShoppingCart implements Serializable {

}
