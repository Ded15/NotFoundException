package ru.netology;

import ru.netology.repository.NotFoundException;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {//добавление продукта
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }
    public Product findById( int id) {
        for (Product product : products){
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) { //удаление продукта
        if (findById(id) == null) {
            throw new NotFoundException(
                    "ID:" + id + "не существует");}
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

        public Product[] findAll() {
            return products;
        }
}
