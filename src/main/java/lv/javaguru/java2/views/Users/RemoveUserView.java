package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.businesslogic.Products.RemoveProductService;
import lv.javaguru.java2.businesslogic.Users.RemoveUserService;
import lv.javaguru.java2.database.Products.ProductDatabase;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.excetions.InvalidDataException;
import lv.javaguru.java2.views.View;

import java.util.List;
import java.util.Scanner;

public class RemoveUserView implements View {

    private RemoveUserService removeUserService;

    public RemoveUserView(UserDatabase database) {
        this.removeUserService = new RemoveUserService(database);
    }
    @Override
    public void execute(Object login) throws InvalidDataException {
        removeUserService.removeUser((String)login);
    }

    @Override
    public Object get(Object model) throws InvalidDataException {
        return null;
    }
}
