package lv.javaguru.java2.views.Products;

import lv.javaguru.java2.businesslogic.Products.FindProductService;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindProductView implements View {

    @Autowired
    private FindProductService findProductService;

    @Override
    public Optional<Product> get(Object product) {
        return findProductService.findProduct(((User) product));
    }
    @Override
    public void execute(Object model) throws InvalidDataException{
    }

}
