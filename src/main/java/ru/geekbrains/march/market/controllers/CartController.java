package ru.geekbrains.march.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        cartService.addItemToCart(id);
    }

    @DeleteMapping
    public String clearCart(){
        cartService.clearCart();
        return String.valueOf(HttpStatus.OK.value());
    }

    @DeleteMapping("/{id}")
    public String removeItemFromCart(@PathVariable Long id){
        cartService.forceDeleteItemInCart(id);
        return String.valueOf(HttpStatus.OK.value());
    }

    @PutMapping("/{id}") // false = decrement; true = increment
    public void changeCount(@PathVariable Long id, @RequestParam boolean turn){
        if (!turn) {
            cartService.decrementItemInCart(id);
        } else {
            cartService.addItemToCart(id);
        }
    }
}