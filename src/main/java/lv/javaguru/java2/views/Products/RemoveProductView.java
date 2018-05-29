package lv.javaguru.java2.views.Products;

import lv.javaguru.java2.businesslogic.Products.RemoveProductService;
import lv.javaguru.java2.businesslogic.Products.UpdateProductService;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.Products.ProductDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class RemoveProductView implements View {

    @Autowired
    private RemoveProductService removeProductService;


    @Override
    public void execute(Object model) throws InvalidDataException {
        removeProductService.removeProduct((Product)model);
    }

    @Override
    public String get(Object model) throws InvalidDataException {
        return null;
    }
}
