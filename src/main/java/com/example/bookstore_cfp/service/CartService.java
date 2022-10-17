package com.example.bookstore_cfp.service;

import com.example.bookstore_cfp.dto.CartDto;
import com.example.bookstore_cfp.model.BookM;
import com.example.bookstore_cfp.model.Cart;
import com.example.bookstore_cfp.model.UserM;
import com.example.bookstore_cfp.repository.BookRepo;
import com.example.bookstore_cfp.repository.CartRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@Service
@Slf4j
public class CartService implements IcartService {
    @Autowired
    CartRepo cartRepo;
    @Autowired
    IUserServe iUserServe;
    @Autowired
    IBookServe iBookServe;
    @Autowired
    BookRepo bookRepo;

    @Override
    public Cart addToCart(CartDto cartDto) {
        UserM userDet = iUserServe.getById(cartDto.getUserId());
        if (userDet != null) {
            BookM bookM = iBookServe.getBookById(cartDto.getBooKId());
            if(cartDto.quantity<bookM.getBookQuant()){
                log.info("cart quantity always greater than book quantity");
            }
            Long totalPrice = cartDto.quantity*bookM.getBookPrice();
            Cart cart = new Cart(cartDto.getQuantity(), userDet, bookM, totalPrice);
            return cartRepo.save(cart);
        }
        return null;
    }


    @Override
    public List<Cart> getAllCart() {
        return cartRepo.findAll();
    }

    @Override
    public Cart getCartById(Integer Id) {
        Cart cart = cartRepo.findById(Id).orElse(null);
        return cart;
    }

    @Override
    public Optional<Cart> deleteCartById(Integer Id) {
        Optional<Cart> cartOpt = cartRepo.findById(Id);
        if(cartOpt != null){
            cartRepo.deleteById(Id);
            return cartOpt;
        }
        return null;
    }

    @Override
    public Cart updateCart(Integer Id, CartDto cartDto) {
        Cart cart = cartRepo.findById(Id).orElse(null);
        if (cart != null) {
            UserM userM = iUserServe.getById(cartDto.userId);
            BookM bookM = iBookServe.getBookById(cartDto.booKId);
            Long totalPrice = cartDto.quantity*bookM.getBookPrice();
            cart.setQuantity(cartDto.getQuantity());
            cart.setUserDetails(userM);
            cart.setBookM(bookM);
            cart.setTotalPrice(totalPrice);
            return cartRepo.save(cart);

        }
        return null;
    }

    @Override
    public Cart incQuanti(Integer Id, Long quant) {
        Optional<Cart> cartDec = cartRepo.findById(Id);
        BookM bookM = iBookServe.getBookById(cartDec.get().getBookM().getBookId());
            if (cartDec.get() != null) {
                if (quant > bookM.bookQuant) {
                    quant = quant + 1;
                    Long totalPrice = quant*bookM.getBookPrice();
                    cartDec.get().setQuantity(quant);
                    cartDec.get().setTotalPrice(totalPrice);
                    cartRepo.save(cartDec.get());


                    return cartDec.get();
                } else {
                    return null;
                }
            }
            return null;
    }

//    @Override
//    public Cart decQuant(Integer Id, Long quant) {
//        Optional<Cart> cartDec = cartRepo.findById(Id);
//        BookM bookM = iBookServe.getBookById(cartDec.get().getBookM().getBookId());
//        if (cartDec != null) {
//            if (quant > cartDec.get().quantity && quant > bookM.bookQuant) {
//                quant = quant - 1;
//
//                cartDec.get().setQuantity(quant);
//                cartRepo.save(cartDec.get());
//                return cartDec.get();
//            } else {
//                return null;
//            }
//        }
//        return null;
//    }

//    @Override
//    public Cart updateQuantity(Integer Id, Long quanti) {
//        Optional<Cart> cart = cartRepo.findById(Id);
//        if (cart.isPresent()) {
//            Optional<BookM> book = bookRepo.findById(cart.get().getBookM().getBookId());
//            System.out.println("UPDATE HITTING ");
//           /* if((book.get().getQuantity()) <0)
//                return null;*/
//
//            if ((book.get().getBookQuant()) < 0) {
//                return null;
//            }
////            if(quantity < book.get().getQuantity()) {
//            if ((book.get().getBookQuant()) >= 0) {
//                cart.get().setQuantity(quanti);
//                cartRepo.save(cart.get());
//                bookRepo.save(book.get());
//                return cart.get();
//
//
//
//            } else {
//                return null;//No sufficient quantity
//            }
//        } else {
//            return null;//cart dosent exist
//        }
//    }
}