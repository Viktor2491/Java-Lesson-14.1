package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repo;


    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }


    public void add(Product product) {
        repo.save(product);
    }
    public  Product[] findAll() {
        return repo.getProducts();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.getProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
                // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getTitle().contains(search)) {
                return true;
            }
            if (book.getAuthor().contains(search)) {
                return true;
            }
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getTitle().contains(search)) {
                return true;
            }
            if (smartphone.getManufacturer().contains(search)) {
                return true;
            }
        }
        return false;
    }
}
