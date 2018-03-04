package lv.javaguru.java2.businesslogic.Users;

import lv.javaguru.java2.database.Products.ProductDatabase;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.models.Product;
import lv.javaguru.java2.models.UserModel;

public class AddUserService {

    private UserDatabase userDatabase;

    public AddUserService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public void addUser(Object model) {
        UserModel userModel = (UserModel) model;
        userDatabase.add(userModel);
    }

}
