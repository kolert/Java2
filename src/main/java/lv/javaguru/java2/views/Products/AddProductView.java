package lv.javaguru.java2.views.Products;

import lv.javaguru.java2.businesslogic.Products.AddProductService;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.Products.ProductDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class AddProductView implements View {

    @Autowired
    private AddProductService addProductService;

    @Override
    public void execute(Object model) throws InvalidDataException {

        addProductService.addProduct((Product)model);
        System.out.println("Product added!");
    }
    @Override
    public Object get(Object model) throws InvalidDataException{
        return null;
    }

}
