package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.businesslogic.responses.UserResponse;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.database.repositorys.UserRepository;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.functions.PasswordFunctions;
import lv.javaguru.java2.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Component
public class AddUserService {

    @Autowired
    private AddUserValidator userValidator;
    @Autowired
    private UserRepository userORMDatabase;
    @Transactional
    public UserResponse addUser(Object model) throws InvalidDataException  {
        User userModel = (User) model;
        java.util.Date utilDate = new java.util.Date();
        userModel.setCreated(new Timestamp(utilDate.getTime()));
        System.out.println("started register");
        System.out.println(model.toString());
        Optional<User> foundUser = userORMDatabase.findUser(userModel);

        if (!foundUser.isPresent()) {
            UserResponse ret = userModel.toUserModel().validate();
            try {
                userModel.setPassword(PasswordFunctions.getSaltedHash(userModel.getPassword()));
                userORMDatabase.save(userModel);
                System.out.println("User Inserted");
            }catch(Exception e){
                e.printStackTrace();
            }
            return ret;
        } else {
            throw new InvalidDataException("User already exists!");
        }
    }

}
