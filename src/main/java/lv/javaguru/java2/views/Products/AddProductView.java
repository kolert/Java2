package lv.javaguru.java2.views.Products;

import lv.javaguru.java2.businesslogic.Products.AddProductService;
import lv.javaguru.java2.database.Products.ProductDatabase;
import lv.javaguru.java2.excetions.InvalidDataException;
import lv.javaguru.java2.views.View;

import java.util.Scanner;

public class AddProductView implements View {

    private AddProductService addProductService;

    public AddProductView(ProductDatabase database) {
        this.addProductService = new AddProductService(database);
    }

    @Override
    public void execute(Object model) throws InvalidDataException {
        System.out.println();
        System.out.println("Add product to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product title:");
        String title = sc.nextLine();
        System.out.print("Enter product description:");
        String description = sc.nextLine();

        addProductService.addProduct(title, description);

        System.out.println("Add product to list execution end!");
        System.out.println();
    }
    @Override
    public Object get(Object model) throws InvalidDataException{
        return null;
    }

}
