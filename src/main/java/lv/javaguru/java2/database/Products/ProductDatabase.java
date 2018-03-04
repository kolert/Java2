package lv.javaguru.java2.database.Products;

import lv.javaguru.java2.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDatabase {

    void add(Product product);

    Optional<Product> findByTitle(String title);

    void remove(Product product);

    List<Product> getAllProducts();

}
