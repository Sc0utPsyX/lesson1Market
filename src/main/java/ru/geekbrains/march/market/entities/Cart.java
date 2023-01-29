package ru.geekbrains.march.market.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Component
@NoArgsConstructor
public class Cart {

    private List<CartItem> productList;
    private int totalPrice;


    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
    }


    public List<CartItem> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public void add(Product product) {
        for (CartItem item: productList){
            if (item.getProductId().equals(product.getId())) {
                item.quantityIncrement();
                recalculate();
                return;
            }
        }
        productList.add(new CartItem(product.getId(),product.getTitle(), 1,product.getPrice(), product.getPrice()));
        recalculate();
    }

    public void decrementQuantity(Product product) {
        for (CartItem item : productList) {
            if (item.getProductId().equals(product.getId())) {
                if (item.getQuantity() <= 1){
                    removeItem(item);
                    return;
                } else {
                    item.quantityDecrement();
                    recalculate();
                }
            }
        }
    }

    private void removeItem(CartItem cartItem){
        productList.remove(cartItem);
        recalculate();
    }

    public void forceRemove(Product product) {
        for (CartItem item : productList) {
            if (item.getProductId().equals(product.getId())) {
                removeItem(item);
                return;
            }
        }
    }

    public void clearCart(){
        productList.clear();
        recalculate();
    }


    private void recalculate() {
        totalPrice = 0;
        for (CartItem item: productList){
            totalPrice += item.getPrice();
        }
    }
}
