package lv.javaguru.java2.views.Products;

import lv.javaguru.java2.businesslogic.Products.FindProductService;
import lv.javaguru.java2.businesslogic.users.FindUserService;
import lv.javaguru.java2.database.DAO.ProductDAO;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.Products.ProductDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowProductListView implements View {

    @Autowired
    private FindProductService findProductService;

    @Override
    public List<Product> get(Object user) {
        return findProductService.getAllProducts();
    }
    @Override
    public void execute(Object model) throws InvalidDataException {
    }
}
