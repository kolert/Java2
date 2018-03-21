package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.businesslogic.responses.UserResponse;
import lv.javaguru.java2.businesslogic.validators.AddUserValidator;
import lv.javaguru.java2.database.DAO.UserDAO;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.models.UserModel;

import java.util.Optional;

public class AddUserService {

    private AddUserValidator userValidator;
    private UserDatabase userDatabase;

    public AddUserService(UserDatabase userDatabase, AddUserValidator userValidator) {
        this.userDatabase = userDatabase;
        this.userValidator = userValidator;
    }
    public AddUserService() {
        this.userDatabase = new UserDAO();
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
