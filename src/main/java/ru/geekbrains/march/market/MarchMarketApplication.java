package ru.geekbrains.march.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarchMarketApplication {
/// Домашнее задание:
//   1. Разобраться в базовом взаимодействии бэк <-> фронт
// 2. Полробуйте реализовать простейший вариант корзины в виде бина-синглтона:
//   - Создаете бин Cart в, который может хранить список товаров
//   - На фронте делаете кнопки "добавить в корзину" рядом с каждым товаром
// - При нажатии на кнопку, товар должен попасть в корзину
// - Под таблицей с товарами отрисуйте таблицу "Корзина", с набором товаров из корзины

	public static void main(String[] args) {
		SpringApplication.run(MarchMarketApplication.class, args);
	}
}
