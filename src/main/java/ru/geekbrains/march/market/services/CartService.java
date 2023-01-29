package ru.geekbrains.march.market.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.march.market.entities.Cart;
import ru.geekbrains.march.market.entities.Product;



@Service
@RequiredArgsConstructor
@Data
public class CartService {

    private final ProductService productService;
    private final Cart cart;


    public void addItemToCart(Long productId){
        Product product = productService.findById(productId).orElseThrow();
        cart.add(product);
    }

    public void clearCart(){
        cart.clearCart();
    }

    public void decrementItemInCart(Long productId){
        Product product = productService.findById(productId).orElseThrow();
        cart.decrementQuantity(product);
    }

    public void forceDeleteItemInCart(Long productId){
        Product product = productService.findById(productId).orElseThrow();
        cart.forceRemove(product);
    }

}
