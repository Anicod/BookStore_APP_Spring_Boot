package com.example.bookstore_cfp.repository;


import com.example.bookstore_cfp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepo extends JpaRepository <Cart, Integer> {
    @Query(value = "update cart  set quantity=:quantit where cart_id=:upId", nativeQuery = true)
    Cart increaseQuant(Long quantit, Integer upId);

}
