package com.example.ckjvweb.service.Impl;

import com.example.ckjvweb.entity.cart.Cart;
import com.example.ckjvweb.repository.ICartRepository;
import com.example.ckjvweb.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    ICartRepository cartRepository;

    @Override
    public List<Cart> findAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public void createCart(Integer bookId, Integer cartQuantity, Double cartTotalMoney) {
        cartRepository.createCart(bookId, cartQuantity, cartTotalMoney);
    }

//    @Override
//    public void paymentCart(Integer cartId) {
//        cartRepository.paymentCart(cartId);
//    }

    @Override
    public void paymentCart() {
        cartRepository.paymentCart();
    }

    @Override
    public void updateCart(Integer quantity, Double totalMoney, Integer cartId) {
        cartRepository.updateCart(quantity,totalMoney,cartId);
    }

    @Override
    public void deleteCart(Integer cartId) {
        cartRepository.deleteOneItem(cartId);
    }
}
