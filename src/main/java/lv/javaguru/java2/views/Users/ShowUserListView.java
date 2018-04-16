package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.database.DAO.UserDAO;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.stereotype.Component;

import java.util.List;

public class ShowUserListView implements View {

    private UserDatabase database;

    public ShowUserListView(UserDatabase database) {
        this.database = database;
    }
    public ShowUserListView() {
        this.database = new UserDAO();
    }

    @Override
    public List<?> get(Object model) throws InvalidDataException {
        return database.getAllUsers();
    }
    @Override
    public void execute(Object model) throws InvalidDataException{
    }

}
