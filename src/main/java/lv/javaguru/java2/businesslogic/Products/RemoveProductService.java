package lv.javaguru.java2.businesslogic.Products;

import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.repositorys.ProductRepository;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.database.Products.ProductDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class RemoveProductService {

    @Autowired
    private ProductRepository productORMDatabase;

    @Transactional
    public void removeProduct(Product product) throws InvalidDataException {
        Product productModel = (Product) product;
        System.out.println("started removing");
        System.out.println(product.toString());
        Optional<Product> foundProduct = productORMDatabase.findProduct(productModel);
        if (foundProduct.isPresent()) {
            productModel = foundProduct.get();
            try {
                productORMDatabase.remove(productModel);
                System.out.println("Product removed!");
            }catch(Exception e){
                e.printStackTrace();
            }
        } else {
            throw new InvalidDataException("Product does not exists!");
        }
    }

}
