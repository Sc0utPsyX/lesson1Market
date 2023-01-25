package ru.geekbrains.march.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.march.market.entities.Cart;
import ru.geekbrains.march.market.services.CartService;



@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public Cart getCart() {
        return cartService.getCart();
    }

    @GetMapping("/{id}")
    public void addProduct(@PathVariable Long id){
        cartService.addNewItemToCart(id);
    }
}