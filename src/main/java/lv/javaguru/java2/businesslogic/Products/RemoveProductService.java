package lv.javaguru.java2.businesslogic.Products;

import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.models.Product;
import lv.javaguru.java2.database.Products.ProductDatabase;

import java.util.Optional;

public class RemoveProductService {

    private ProductDatabase productDatabase;

    public RemoveProductService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public boolean removeProduct(String title) throws InvalidDataException {
        Optional<Product> foundProduct = productDatabase.findByTitle(title);
        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
            productDatabase.remove(product);
            return true;
        } else {
            throw new InvalidDataException("No product with title "+title);
        }
    }

}
