package com.example.bookstore_cfp.dto;

import com.example.bookstore_cfp.model.UserM;
import lombok.Data;

@Data
public class CartDto {
    public Long quantity;
    public Integer userId;
    public Integer booKId;

    public CartDto(Long quantity, Integer userId, Integer booKId) {
        this.quantity = quantity;
        this.userId = userId;
        this.booKId = booKId;
    }
}
