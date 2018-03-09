package lv.javaguru.java2.businesslogic.Users;

import lv.javaguru.java2.database.Products.ProductDatabase;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.excetions.InvalidDataException;
import lv.javaguru.java2.models.Product;
import lv.javaguru.java2.models.UserModel;

import java.util.Optional;

public class RemoveUserService {

    private UserDatabase userDatabase;

    public RemoveUserService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public boolean removeUser(String login) throws InvalidDataException {
        Optional<UserModel> foundUser = userDatabase.findByLogin(login);
        if (foundUser.isPresent()) {
            UserModel product = foundUser.get();
            userDatabase.remove(product);
            return true;
        } else {
            throw new InvalidDataException("No User foudn with login "+login);
        }
    }

}
