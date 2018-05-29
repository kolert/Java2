package lv.javaguru.java2.businesslogic.Products;

import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.repositorys.ProductRepository;
import lv.javaguru.java2.database.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class FindProductService {
    @Autowired
    private ProductRepository productRepository;
    @Transactional
    public Optional<Product> findProduct(Product model) {
        Optional<Product> foundUser = productRepository.findProduct(model);
        return foundUser;
    }
    @Transactional
    public List<Product> getAllProducts() {
        List<Product> allProducts = productRepository.getAllProducts();
        return allProducts;
    }

}
