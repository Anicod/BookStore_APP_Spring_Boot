package com.example.bookstore_cfp.dto;

public class CartResponseDto {
    public Object cartData;
    public String confirmMess;

    public Object getCartData() {
        return cartData;
    }

    public void setCartData(Object cartData) {
        this.cartData = cartData;
    }

    public String getConfirmMess() {
        return confirmMess;
    }

    public void setConfirmMess(String confirmMess) {
        this.confirmMess = confirmMess;
    }

    public CartResponseDto(Object cartData, String confirmMess) {
        this.cartData = cartData;
        this.confirmMess = confirmMess;
    }
}
