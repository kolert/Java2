package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.database.Entities.UserEntity;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.models.UserModel;

import java.util.Optional;

public class RemoveUserService {

    private UserDatabase userDatabase;

    public RemoveUserService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public boolean removeUser(String login) throws InvalidDataException {
        UserModel remUser = new UserModel();
        remUser.setLogin(login);
        Optional<UserEntity> foundUser = userDatabase.findUser(remUser);
        if (foundUser.isPresent()) {
            UserModel user = foundUser.get().toUserModel();
            userDatabase.remove(user);
            return true;
        } else {
            throw new InvalidDataException("No User foudn with login "+login);
        }
    }

}
