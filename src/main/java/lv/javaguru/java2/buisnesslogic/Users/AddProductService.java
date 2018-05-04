package lv.javaguru.java2.buisnesslogic.Users;

import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.Products.ProductDatabase;

public class AddProductService {

    private ProductDatabase productDatabase;

    public AddProductService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public void addProduct(String title,
                           String description) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        productDatabase.add(product);
    }

}