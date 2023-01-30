package ru.geekbrains.march.market;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.geekbrains.march.market.aspect.DebugServiceAspect;

@SpringBootApplication
@Slf4j
public class MarchMarketApplication {
/// Домашнее задание:
// 1. Группировка продуктов в корзине
// 2. Добавляете возможно по кнопке на фронте очишать корзину
// 3.* Добавьте возможность ивеличивать/именьшать кол-во товаров в одной "продиктовой стооке" корзины
// 4.* Добавьте возможность удалять "продуктовую строку" корзины


	public static void main(String[] args) {
		SpringApplication.run(MarchMarketApplication.class, args);
	}

}
