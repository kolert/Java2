package lv.javaguru.java2.businesslogic.Products;

import lv.javaguru.java2.excetions.InvalidDataException;
import lv.javaguru.java2.models.Product;
import lv.javaguru.java2.database.Products.ProductDatabase;

public class AddProductService {

    private ProductDatabase productDatabase;

    public AddProductService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public void addProduct(String title,
                           String description) throws InvalidDataException {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        productDatabase.add(product);
    }

}
