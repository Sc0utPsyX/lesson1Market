package ru.geekbrains.march.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.march.market.aspect.Timer;
import ru.geekbrains.march.market.entities.Product;

import java.util.Optional;

@Repository
@Timer
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    Optional<Product> findByTitle(String title);
}