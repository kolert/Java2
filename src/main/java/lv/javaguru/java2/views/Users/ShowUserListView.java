package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.database.Products.ProductDatabase;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.models.Product;
import lv.javaguru.java2.models.UserModel;
import lv.javaguru.java2.views.View;

import java.util.List;

public class ShowUserListView implements View {

    private UserDatabase database;

    public ShowUserListView(UserDatabase database) {
        this.database = database;
    }

    @Override
    public List<?> get(){
        return database.getAllUsers();
    }
    @Override
    public void execute(Object model) {
    }

}
