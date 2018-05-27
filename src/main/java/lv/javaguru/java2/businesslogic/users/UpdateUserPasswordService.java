package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.repositorys.UserRepository;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.functions.PasswordFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class UpdateUserPasswordService {

    @Autowired
    private AddUserValidator userValidator;
    @Autowired
    private UserRepository userORMDatabase;
    @Transactional
    public void update(Object model) throws InvalidDataException  {
        User userModel = (User) model;
        System.out.println("started update");
        System.out.println(model.toString());
        Optional<User> foundUser = userORMDatabase.findUser(userModel);
        if (foundUser.isPresent()) {
            String pass = userModel.getPassword();
            userModel = foundUser.get();
            //Response ret = userModel.toUserModel().validate();
            try {
                userModel.setPassword(PasswordFunctions.getSaltedHash(pass));
                userORMDatabase.update(userModel);
                System.out.println("User updated");
            }catch(Exception e){
                e.printStackTrace();
            }
            //return ret;
        } else {
            throw new InvalidDataException("User does not exists!");
        }
    }

}
