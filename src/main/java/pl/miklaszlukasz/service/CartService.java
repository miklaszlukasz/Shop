package pl.miklaszlukasz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by rogonion on 12.09.16.
 */
@Service
public class CartService {
    @Autowired
    private HttpSession httpSession;
}
