package lv.javaguru.java2.database.Users;

import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserDatabase {

    void add(User userModel);

    Optional<User> findUser(UserModel User);

    void remove(UserModel userModel);

    List<User> getAllUsers();

}
