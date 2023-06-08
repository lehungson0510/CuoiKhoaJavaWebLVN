package com.example.ckjvweb.repository;

import com.example.ckjvweb.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICartRepository extends JpaRepository<Cart, Integer> {

    @Modifying
    @Query(value = "INSERT INTO cart (book_id, cart_quantity, cart_total_money) VALUES (?,?,?)", nativeQuery = true)
    void createCart(Integer bookId, Integer cartQuantity, Double cartTotalMoney);

    @Modifying
    @Query(value = "delete from cart", nativeQuery = true)
    void paymentCart();

    @Modifying
    @Query(value = "update cart set cart_quantity = ?1, cart_total_money = ?2 where cart_id = ?3", nativeQuery = true)
    void updateCart(Integer quantity, Double totalMoney, Integer cartId);

    @Modifying
    @Query(value = "delete from cart where cart_id =?1", nativeQuery = true)
    void deleteOneItem(Integer idCart);
}
