package lv.javaguru.java2.views.Products;

import lv.javaguru.java2.models.Product;
import lv.javaguru.java2.database.Products.ProductDatabase;
import lv.javaguru.java2.views.View;

public class ShowProductListView implements View {

    private ProductDatabase database;

    public ShowProductListView(ProductDatabase database) {
        this.database = database;
    }

    @Override
    public void execute(Object model) {
        System.out.println();
        System.out.println("Print shopping list to console execution start!");
        for (Product product : database.getAllProducts()) {
            System.out.println(product.getTitle() + "[" + product.getDescription() + "]");
        }
        System.out.println("Print shopping list to console execution end!");
        System.out.println();
    }
    @Override
    public Object get(){
        return null;
    }
}
