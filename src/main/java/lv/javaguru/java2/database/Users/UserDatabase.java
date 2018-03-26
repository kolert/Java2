package lv.javaguru.java2.database.Users;

import lv.javaguru.java2.models.Product;
import lv.javaguru.java2.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserDatabase {

    void add(UserModel userModel);

    Optional<UserModel> findByLogin(String login);
    Optional<UserModel> findByName(String name);
    Optional<UserModel> findBySurname(String surname);

    void remove(UserModel userModel);

    List<UserModel> getAllUsers();

}
