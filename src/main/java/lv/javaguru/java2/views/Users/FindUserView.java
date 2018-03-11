package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.models.UserModel;
import lv.javaguru.java2.views.View;

import java.util.Optional;

public class FindUserView implements View {

    private UserDatabase database;

    public FindUserView(UserDatabase database) {
        this.database = database;
    }

    @Override
    public Optional<UserModel> get(Object login) throws InvalidDataException {
        return database.findByLogin(((String) login));
    }
    @Override
    public void execute(Object model) throws InvalidDataException{
    }

}
