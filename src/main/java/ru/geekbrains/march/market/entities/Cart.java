package ru.geekbrains.march.market.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
@NoArgsConstructor
public class Cart {

    private List<Product> productList;


    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
    }

}
