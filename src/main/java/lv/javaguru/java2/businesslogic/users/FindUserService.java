package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.businesslogic.responses.UserResponse;
import lv.javaguru.java2.database.Entities.UserEntity;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.functions.PasswordFunctions;
import lv.javaguru.java2.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Component
public class FindUserService {
    @Autowired
    private UserDatabase userORMDatabase;
    @Transactional
    public Optional<UserModel> findUser(Object model) {
        UserModel userModel = (UserModel) model;
        Optional<UserModel> foundUser = userORMDatabase.findUser(userModel);
        return foundUser;
    }

}
