package lv.javaguru.java2.database.Users;

import lv.javaguru.java2.database.Entities.User;

import java.util.List;
import java.util.Optional;

public interface UserDatabase {

    void add(User userModel);

    Optional<User> findUser(User User);

    void remove(User userModel);

    List<User> getAllUsers();

}
