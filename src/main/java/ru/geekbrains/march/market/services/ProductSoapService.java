package ru.geekbrains.march.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.march.market.entities.Product;
import ru.geekbrains.march.market.repositories.ProductRepository;
import ru.geekbrains.march.market.soap.ProductSoap;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductSoapService {
    private final ProductRepository productRepository;

    public static final Function<Product, ProductSoap> entityToSoap = p -> {
        ProductSoap ps = new ProductSoap();
        ps.setId(p.getId());
        ps.setTitle(p.getTitle());
        ps.setPrice(p.getPrice());
        return ps;
    };

    public List<ProductSoap> getAllProducts(){
        return productRepository.findAll().stream().map(entityToSoap).collect(Collectors.toList());
    }

    public ProductSoap getByTitle(String title) {
        return productRepository.findByTitle(title).map(entityToSoap).orElseThrow();
    }

}
