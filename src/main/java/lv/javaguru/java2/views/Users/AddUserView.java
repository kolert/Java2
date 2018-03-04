package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.businesslogic.Products.AddProductService;
import lv.javaguru.java2.businesslogic.Users.AddUserService;
import lv.javaguru.java2.database.Products.ProductDatabase;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.models.UserModel;
import lv.javaguru.java2.views.View;

import java.util.Scanner;

public class AddUserView implements View {

    private AddUserService addUserService;

    public AddUserView(UserDatabase database) {
        this.addUserService = new AddUserService(database);
    }
    @Override
    public Object get(){
        return null;
    }
    @Override
    public void execute(Object model) {
        addUserService.addUser(model);
    }

}
