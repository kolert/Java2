package lv.javaguru.java2.businesslogic.users;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import lv.javaguru.java2.businesslogic.responses.UserResponse;
import lv.javaguru.java2.database.Entities.UserEntity;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.database.Users.UserORMDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.functions.PasswordFunctions;
import lv.javaguru.java2.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Component
public class AddUserService {

    @Autowired
    private AddUserValidator userValidator;
    @Autowired
    private UserDatabase userORMDatabase;
    @Transactional
    public UserResponse addUser(Object model) throws InvalidDataException  {
        UserModel userModel = (UserModel) model;
        userModel.setCreated(new Date());
        System.out.println("started register");
        System.out.println(model.toString());
        Optional<UserModel> foundUser = userORMDatabase.findUser(userModel);

        if (!foundUser.isPresent()) {
            UserResponse ret = userModel.validate();
            try {
                userModel.setPassword(PasswordFunctions.getSaltedHash(userModel.getPassword()));
                UserEntity userEntity = new UserEntity();
                userEntity.setModel(userModel);
                userORMDatabase.add(userEntity);
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
