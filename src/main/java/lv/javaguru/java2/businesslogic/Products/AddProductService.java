package lv.javaguru.java2.businesslogic.Products;

import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.repositorys.ProductRepository;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.database.Products.ProductDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddProductService {

    @Autowired
    private ProductRepository productDatabase;

    public AddProductService(ProductRepository productDatabase) {
        this.productDatabase = productDatabase;
    }

    public void addProduct(Product product) {
        productDatabase.save(product);
    }

}
