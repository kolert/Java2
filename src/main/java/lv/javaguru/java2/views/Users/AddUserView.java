package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.businesslogic.users.AddUserService;
import lv.javaguru.java2.businesslogic.validators.AddUserValidator;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;

public class AddUserView implements View {

    private AddUserService addUserService;

    public AddUserView(UserDatabase database, AddUserValidator validator) {
        this.addUserService = new AddUserService(database, validator);
    }
    @Override
    public Object get(Object model) throws InvalidDataException{
        return null;
    }
    @Override
    public void execute(Object model) throws InvalidDataException {
        addUserService.addUser(model);
    }

}
