package lv.javaguru.java2.businesslogic.Products;

import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.database.Products.ProductDatabase;
import org.springframework.stereotype.Component;

@Component
public class AddProductService {

    private ProductDatabase productDatabase;

    public AddProductService(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public void addProduct(String title,
                           String description,
                           String imgUrl) throws InvalidDataException {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImgUrl(imgUrl);
        productDatabase.add(product);
    }

}
