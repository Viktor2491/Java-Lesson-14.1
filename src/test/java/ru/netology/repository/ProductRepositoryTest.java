package ru.netology.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    ru.netology.repository.ProductRepository repo = new ru.netology.repository.ProductRepository();

    Product book1 = new Book(1, "Война и мир", 250, "Лев Толстой");
    Product book2 = new Book(2, "Идиот", 300, "Федор Достоевский");
    Product book3 = new Book(3, "Мертвые души", 350, "Николай Гоголь");
    Product smartphone1 = new Smartphone(4, "xiaomi mi A2", 12000, "Xiaomi Corporation");
    Product smartphone2 = new Smartphone(5, "redmi note 11", 25000, "Xiaomi Corporation");

    @BeforeEach
    public void SetUp() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
    }

    @Test
    //показать весь список товаров
    public void shouldFindAllProducts() {
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //добавление нового продукта
    public void shouldAddProduct() {
        Smartphone smartphone3 = new Smartphone(6, "Iphone", 50000, "Apple");
        repo.save(smartphone3);
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.getProducts();
    }

    @Test
    //добавление по ид
    public void shouldFindById() {

        Product expected = smartphone1;
        Product actual = repo.findById(4);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    //не долен добавлять по ид товара, который не добавлен
    public void shouldNotFindById() {

        Product expected = null;
        Product actual = repo.findById(10);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    //удаление по ид
    public void shouldRemoveProductById() {
        repo.removeProductById (1);
        Product[] expected = {book2, book3, smartphone1, smartphone2};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    //отрицательный ид
    public void shouldRemoveProductById2() {

        Assertions.assertThrows(NotFoundException.class,() -> {
            repo.removeProductById(-10);
        });
    }

}

