package com.example.bookstore_cfp.model;
import com.example.bookstore_cfp.dto.CartDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer cartId;
    public Long quantity;
//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_Id")
    public UserM userDetails;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_bookId")
    public BookM bookM;
    public Long totalPrice;

    public Cart(){

    }
    public Cart(Long quantity, UserM userM, BookM bookM, Long totalPrice){
        this.quantity = quantity;
        this.userDetails = userM;
        this.bookM = bookM;
        this.totalPrice = totalPrice;
    }



}
