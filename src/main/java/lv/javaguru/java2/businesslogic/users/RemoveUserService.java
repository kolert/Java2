package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.database.repositorys.UserRepository;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class RemoveUserService {
    @Autowired
    private UserRepository userORMDatabase;

    public boolean removeUser(String login) throws InvalidDataException {
        User remUser = new User();
        remUser.setLogin(login);
        Optional<User> foundUser = userORMDatabase.findUser(remUser);
        if (foundUser.isPresent()) {
            //UserModel user = foundUser.get().toUserModel();
            userORMDatabase.remove(foundUser.get());
            return true;
        } else {
            throw new InvalidDataException("No User foudn with login "+login);
        }
    }

}
