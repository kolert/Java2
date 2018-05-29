package lv.javaguru.java2.database.repositorys;

import lv.javaguru.java2.database.Entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);
    void remove(Product product);
    void update(Product product);
    List<Product> getAllProducts();
    Optional<Product> findProduct(Product product);
}
