package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.database.DAO.UserDAO;
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
    public FindUserView() {
        this.database = new UserDAO();
    }

    @Override
    public Optional<UserModel> get(Object user) throws InvalidDataException {
        return database.findUser(((UserModel) user));
    }
    @Override
    public void execute(Object model) throws InvalidDataException{
    }

}
