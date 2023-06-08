package com.example.ckjvweb.service;

import com.example.ckjvweb.entity.cart.Cart;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface ICartService {
    List<Cart> findAllCart();

    void createCart(Integer bookId, Integer cartQuantity, Double cartTotalMoney);

//    void paymentCart(Integer cartId);

    void paymentCart();

    void updateCart(Integer quantity, Double totalMoney, Integer cartId);

    void deleteCart(Integer cartId);
}
