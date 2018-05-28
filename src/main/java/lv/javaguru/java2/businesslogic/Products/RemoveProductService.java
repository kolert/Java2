package lv.javaguru.java2.businesslogic.Products;

import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.repositorys.ProductRepository;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.database.Products.ProductDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoveProductService {

    @Autowired
    private ProductRepository productDatabase;

    public boolean removeProduct(String title) throws InvalidDataException {
        Product prod = new Product();
        prod.setTitle(title);
        Optional<Product> foundProduct = productDatabase.findProduct(prod);
        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
            productDatabase.remove(product);
            return true;
        } else {
            throw new InvalidDataException("No product with title "+title);
        }
    }

}
