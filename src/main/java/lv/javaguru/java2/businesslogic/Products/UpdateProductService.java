package lv.javaguru.java2.businesslogic.Products;

import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.repositorys.ProductRepository;
import lv.javaguru.java2.exceptions.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class UpdateProductService {

    @Autowired
    private ProductRepository productORMDatabase;
    @Transactional
    public void update(Object model) throws InvalidDataException {
        Product productModel = (Product) model;
        System.out.println("started update");
        System.out.println(model.toString());
        Optional<Product> foundProduct = productORMDatabase.findProduct(productModel);
        if (foundProduct.isPresent()) {
            productModel = foundProduct.get();
            try {
                productModel.setTitle(((Product)model).getTitle());
                productModel.setDescription(((Product)model).getDescription());
                productModel.setImgUrl(((Product)model).getImgUrl());
                productORMDatabase.update(productModel);
                System.out.println("User updated");
            }catch(Exception e){
                e.printStackTrace();
            }
        } else {
            throw new InvalidDataException("User does not exists!");
        }
    }

}
