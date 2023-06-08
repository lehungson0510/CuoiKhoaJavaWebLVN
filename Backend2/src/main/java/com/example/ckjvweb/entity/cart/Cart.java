package com.example.ckjvweb.entity.cart;

import com.example.ckjvweb.entity.book.Book;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    private Integer cartQuantity;

    private Double cartTotalMoney;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @JsonManagedReference
    private Book book;

    public Cart() {
    }

    public Cart(Integer cartId, Integer cartQuantity, Double cartTotalMoney, Book book) {
        this.cartId = cartId;
        this.cartQuantity = cartQuantity;
        this.cartTotalMoney = cartTotalMoney;
        this.book = book;
    }

    public Cart(Integer cartQuantity, Double cartTotalMoney, Book book) {
        this.cartQuantity = cartQuantity;
        this.cartTotalMoney = cartTotalMoney;
        this.book = book;
    }

    public Cart(Integer cartQuantity, Double cartTotalMoney) {
        this.cartQuantity = cartQuantity;
        this.cartTotalMoney = cartTotalMoney;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer orderId) {
        this.cartId = orderId;
    }

    public Integer getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(Integer orderQuantity) {
        this.cartQuantity = orderQuantity;
    }

    public Double getCartTotalMoney() {
        return cartTotalMoney;
    }

    public void setCartTotalMoney(Double orderTotalMoney) {
        this.cartTotalMoney = orderTotalMoney;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
