package com.example.storecartservice.controller;

import com.example.storecartservice.model.UserCart;
import com.example.storecartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping("/{userId}")
    public UserCart getCart(@PathVariable("userId") Long userId) {
        return service.getUserProducts(userId);
    }
}
