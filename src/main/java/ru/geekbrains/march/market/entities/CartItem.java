package ru.geekbrains.march.market.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Long productId;
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;


    public void quantityIncrement(){
        this.quantity++;
        calculate();
    };

    public void quantityDecrement(){
        this.quantity--;
        calculate();
    };


    public void calculate(){
        this.price = this.pricePerProduct * this.quantity;
    }
}
