package com.example.ckjvweb.controller;

import com.example.ckjvweb.entity.book.Book;
import com.example.ckjvweb.entity.cart.Cart;
import com.example.ckjvweb.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/cart")
public class CartController {
    @Autowired
    ICartService cartService;

    @GetMapping("/list")
    public ResponseEntity<List<Cart>> findAllCart() {
        List<Cart> cartList = cartService.findAllCart();
//        if (cartList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
            return new ResponseEntity<>(cartList, HttpStatus.OK);
//        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCart(@RequestBody Cart cart) {
        cartService.createCart(cart.getBook().getBookId(), cart.getCartQuantity(), cart.getCartTotalMoney());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editCart(@PathVariable("id") Integer id, @RequestBody Cart cart) {
        cartService.updateCart(cart.getCartQuantity(), cart.getCartTotalMoney(), id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/payment")
    public ResponseEntity<?> paymentCart() {
        cartService.paymentCart();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable("cartId") Integer cartId) {
        cartService.deleteCart(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add-one-book")
    public ResponseEntity<?> addOneBook(@RequestBody Book book) {
        List<Cart> cartList = cartService.findAllCart();
        boolean isExists = false;
        for (Cart cart : cartList) {
            System.out.println(book);
            if (cart.getBook().getBookId() == book.getBookId()) {
                int quantity = cart.getCartQuantity();
                double price = cart.getCartTotalMoney() + book.getBookPrice();
                cartService.updateCart(quantity + 1, price, cart.getCartId());
                isExists = true;
                break;
            }
        }
        if(!isExists) {
            double price = book.getBookPrice();
            cartService.createCart(book.getBookId(),1,price);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/change-quantity/{quantity}")
    public ResponseEntity<?> changeQuantity(@RequestBody Book book, @PathVariable("quantity") Integer quantity) {
        List<Cart> cartList = cartService.findAllCart();
        boolean isExists = false;
        for (Cart cart : cartList) {
            System.out.println(book);
            if (cart.getBook().getBookId() == book.getBookId()) {
                double price = book.getBookPrice()*quantity;
                System.out.println(price);
                cartService.updateCart(quantity, price, cart.getCartId());
                isExists = true;
                break;
            }
        }
        if(!isExists) {
            double price = book.getBookPrice()*quantity;
            cartService.createCart(book.getBookId(),quantity,price);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


