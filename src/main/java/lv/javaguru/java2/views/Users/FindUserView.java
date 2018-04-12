package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.businesslogic.users.AddUserService;
import lv.javaguru.java2.businesslogic.users.FindUserService;
import lv.javaguru.java2.database.DAO.UserDAO;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.models.UserModel;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FindUserView implements View {

    @Autowired
    private FindUserService findUserService;

    @Override
    public Optional<UserModel> get(Object user) {
        return findUserService.findUser(((UserModel) user));
    }
    @Override
    public void execute(Object model) throws InvalidDataException{
    }

}
