package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Book product1 = new Book(11, "Гарри Поттер", 1_200, "Джоан Роулинг");
    Book product2 = new Book(33, "Источники множественного дохода", 720, "Роберт Аллен");
    Smartphone product3 = new Smartphone(5, "Samsung A20", 24_000, "Корея");
    Smartphone product4 = new Smartphone(48, "Nokia 310", 2_300, "Финляндия");

    @Test
    public void save() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void save2() {
        ProductRepository repo = new ProductRepository();
        repo.save(product3);
        repo.save(product4);

        Product[] expected = {product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeId() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.removeById(product1.getId());

        Product[] expected = {product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addText() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Гарри Поттер");

        Assertions.assertArrayEquals(expected, actual);
    }
}
