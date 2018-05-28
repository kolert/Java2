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
    public void update(Object model) throws InvalidDataException  {
        User userModel = (User) model;
        System.out.println("started update");
        System.out.println(model.toString());
        Optional<User> foundUser = userORMDatabase.findUser(userModel);
        if (foundUser.isPresent()) {
            try {
                System.out.println(userModel.toString());
                userORMDatabase.update(userModel);
                System.out.println("User updated");
            }catch(Exception e){
                e.printStackTrace();
            }
        } else {
            throw new InvalidDataException("User does not exists!");
        }
    }

}
