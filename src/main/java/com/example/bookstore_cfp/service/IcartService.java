package com.example.bookstore_cfp.service;

import com.example.bookstore_cfp.dto.CartDto;
import com.example.bookstore_cfp.model.Cart;

import java.util.List;
import java.util.Optional;

public interface IcartService {
    Cart addToCart(CartDto cartDto);
    List<Cart> getAllCart();
    Cart getCartById(Integer Id);
    Optional<Cart> deleteCartById (Integer Id);
    Cart updateCart(Integer Id, CartDto cartDto);
    Cart incQuanti(Integer Id, Long quant);
//    Cart decQuant(Integer Id, Long quant);
//    Cart updateQuantity(Integer Id, Long quanti);
}
