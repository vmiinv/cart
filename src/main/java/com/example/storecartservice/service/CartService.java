package com.example.storecartservice.service;


import com.example.storecartservice.model.CartItem;
import com.example.storecartservice.model.UserCart;
import com.example.storecartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<CartItem> getCart(Long id) {
        return cartRepository.findByProductId(id);
    }

    public UserCart getUserProducts(Long userId) {
       List<CartItem> list = cartRepository.findByProductId(userId);

       UserCart userCart = new UserCart();
       userCart.setCartList(list);
       return  userCart;
    }

    public CartItem create(CartItem cartItem) {
        return cartRepository.saveAndFlush(cartItem);
    }
}
