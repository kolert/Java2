package lv.javaguru.java2.businesslogic.Users;

import lv.javaguru.java2.businesslogic.responses.UserResponse;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.excetions.InvalidDataException;
import lv.javaguru.java2.models.UserModel;

import java.util.Optional;

public class AddUserService {

    private UserDatabase userDatabase;

    public AddUserService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public UserResponse addUser(Object model) throws InvalidDataException {
        UserModel userModel = (UserModel) model;
        Optional<UserModel> foundUser = userDatabase.findByLogin(userModel.getLogin());
        if (!foundUser.isPresent()) {
            UserResponse ret = userModel.validate();
            userDatabase.add(userModel);
            return ret;
        } else {
            throw new InvalidDataException("User already exists!");
        }
    }

}
