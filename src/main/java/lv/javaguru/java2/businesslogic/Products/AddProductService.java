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

    public void addProduct(String title,
                           String description,
                           String imgUrl) throws InvalidDataException {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImgUrl(imgUrl);
        productDatabase.save(product);
    }

}
