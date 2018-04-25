package lv.javaguru.java2.database.repositorys;

import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);
    void remove(Product product);
    List<Product> getAllProducts();
    Optional<Product> findProduct(Product product);
}
