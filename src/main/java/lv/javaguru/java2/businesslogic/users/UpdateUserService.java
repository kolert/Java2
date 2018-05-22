package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.businesslogic.responses.Response;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.repositorys.UserRepository;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.functions.PasswordFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

@Component
public class UpdateUserService {

    @Autowired
    private AddUserValidator userValidator;
    @Autowired
    private UserRepository userORMDatabase;
    @Transactional
    public Response update(Object model) throws InvalidDataException  {
        User userModel = (User) model;
        java.util.Date utilDate = new java.util.Date();
        userModel.setCreated(new Timestamp(utilDate.getTime()));
        System.out.println("started register");
        System.out.println(model.toString());
        Optional<User> foundUser = userORMDatabase.findUser(userModel);

        if (foundUser.isPresent()) {
            Response ret = userModel.toUserModel().validate();
            try {
                userModel.setPassword(PasswordFunctions.getSaltedHash(userModel.getPassword()));
                userORMDatabase.update(userModel);
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