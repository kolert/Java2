package lv.javaguru.java2.views.Products;

import lv.javaguru.java2.businesslogic.Products.AddProductService;
import lv.javaguru.java2.database.Products.ProductDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class AddProductView implements View {

    @Autowired
    private AddProductService addProductService;

    @Override
    public void execute(Object model) throws InvalidDataException {
        System.out.println();
        System.out.println("Add product to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product title:");
        String title = sc.nextLine();
        System.out.print("Enter product description:");
        String description = sc.nextLine();
        System.out.print("Enter product img url:");
        String imgUrl = sc.nextLine();

        addProductService.addProduct(title, description, imgUrl);

        System.out.println("Add product to list execution end!");
        System.out.println();
    }
    @Override
    public Object get(Object model) throws InvalidDataException{
        return null;
    }

}
