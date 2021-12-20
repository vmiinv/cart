package com.example.storecartservice.controller;

import com.example.storecartservice.model.CartItem;
import com.example.storecartservice.model.UserCart;
import com.example.storecartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping("/{userId}")
    public UserCart getCart(@PathVariable("userId") Long userId) {
        return service.getUserProducts(userId);
    }

    @PostMapping("")
    public ResponseEntity addCart(@RequestBody CartItem cartItem) {
        return ResponseEntity.ok(service.create(cartItem));
    }

    @DeleteMapping("/{cartId}")
    public void delete(@PathVariable("cartId") Long id) {
        service.delete(id);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteAll(@PathVariable("userId") Long id) {
        service.deleteAll(id);
    }
}
