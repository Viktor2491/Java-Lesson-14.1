package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    Product[] products = new Product[0];

    public void save(Product productForAdd) {
        Product product1 = findById(productForAdd.getId());
        if(product1 != null){
            throw new AlreadyExistsException(
                    "Element with id: " + productForAdd.getId() + " already exists"
            );
        }

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = productForAdd;
        products = tmp;
    }

    public Product[] getProducts() {
        return products;
    }

    public void removeProductById(int id) {
        Product product2 = findById(id);

        if(product2 == null){
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    public Product[] getSavedProducts () {
        return products;
    }

}
