package com.example.bookstore_cfp.controller;

import com.example.bookstore_cfp.dto.CartDto;
import com.example.bookstore_cfp.dto.CartResponseDto;
import com.example.bookstore_cfp.model.Cart;
import com.example.bookstore_cfp.model.UserM;
import com.example.bookstore_cfp.service.IcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CartController {
    @Autowired
    IcartService icartService;

    @PostMapping("/addcart")
    ResponseEntity<CartResponseDto> addCart(@RequestBody CartDto cartDto){
        Cart cartData = icartService.addToCart(cartDto);
        CartResponseDto cartResponseDto = new CartResponseDto(cartData, "added to cart successfully");
        return new ResponseEntity<>(cartResponseDto, HttpStatus.OK);
    }
    @GetMapping("/allcart")
    ResponseEntity<CartResponseDto> getAll(){
        List<Cart> cartList = icartService.getAllCart();
        CartResponseDto cartResponseDto = new CartResponseDto(cartList, "all carts here");
        return new ResponseEntity<>(cartResponseDto, HttpStatus.OK);
    }
    @GetMapping("/cartbyid")
    ResponseEntity<CartResponseDto> cartById(@RequestParam Integer Id){
        Cart cart = icartService.getCartById(Id);
        CartResponseDto cartResponseDto = new CartResponseDto(cart, "cart present place your order");
        return new ResponseEntity<>(cartResponseDto, HttpStatus.OK);
    }
    @PutMapping("/updatecart/{Id}")
    ResponseEntity<CartResponseDto> updateCart(@PathVariable Integer Id, @RequestBody CartDto cartDto){
        Cart cartUpate = icartService.updateCart(Id, cartDto);
        CartResponseDto cartResponseDto = new CartResponseDto(cartUpate, "cart updated successfully");
        return new ResponseEntity<>(cartResponseDto, HttpStatus.OK);

    }
    @DeleteMapping("/deletecart/{Id}")
    ResponseEntity<CartResponseDto> deleteCart(@PathVariable Integer Id){
       Optional<Cart>  cartOpt = icartService.deleteCartById(Id);
    CartResponseDto cartResponseDto = new CartResponseDto(cartOpt, "deleted");
    return new ResponseEntity<>(cartResponseDto,HttpStatus.OK);
    }
    @PutMapping("/incquant/{Id}")
    ResponseEntity<CartResponseDto> incQunt(@PathVariable Integer Id, @RequestParam Long quantity ){
        Cart cart = icartService.incQuanti(Id, quantity);
        CartResponseDto cartResponseDto = new CartResponseDto(cart, "increase quantity updated");
        return new ResponseEntity<>(cartResponseDto, HttpStatus.OK);

    }
//    @PutMapping("/decquant/{Id}")
//    ResponseEntity<CartResponseDto> decQunt(@PathVariable Integer Id, @RequestParam Long quantity ){
//        Cart cart = icartService.decQuant(Id, quantity);
//        CartResponseDto cartResponseDto = new CartResponseDto(cart, "decrease quantity updated");
//        return new ResponseEntity<>(cartResponseDto, HttpStatus.OK);
//
//    }
//    @PutMapping("/updateq/{Id}")
//    ResponseEntity<CartResponseDto> updateQ(@PathVariable Integer Id, @RequestParam Long quantity){
//        Cart cart = icartService.updateQuantity(Id, quantity);
//        CartResponseDto cartResponseDto = new CartResponseDto(cart, "quantity updated");
//        return new ResponseEntity<>(cartResponseDto, HttpStatus.OK);
//    }
}
