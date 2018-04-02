package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.businesslogic.responses.UserResponse;
import lv.javaguru.java2.businesslogic.validators.AddUserValidator;
import lv.javaguru.java2.database.DAO.UserDAO;
import lv.javaguru.java2.database.Entities.UserEntity;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.functions.PasswordFunctions;
import lv.javaguru.java2.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AddUserService {

    @Autowired
    private AddUserValidator userValidator;
    @Autowired
    private UserDatabase userDatabase;

    public UserResponse addUser(Object model) throws InvalidDataException  {
        UserModel userModel = (UserModel) model;
        Optional<UserModel> foundUser = userDatabase.findUser(userModel);

        if (!foundUser.isPresent()) {
            UserResponse ret = userModel.validate();
            try {
                userModel.setPassword(PasswordFunctions.getSaltedHash(userModel.getPassword()));
                UserEntity userEntity = new UserEntity();
                userEntity.setModel(userModel);
                userDatabase.add(userEntity);
            }catch(Exception e){
                e.printStackTrace();
            }
            return ret;
        } else {
            throw new InvalidDataException("User already exists!");
        }
    }

}
