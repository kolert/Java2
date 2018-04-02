package lv.javaguru.java2.database.Users;

import lv.javaguru.java2.database.Entities.UserEntity;
import lv.javaguru.java2.models.Product;
import lv.javaguru.java2.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserDatabase {

    void add(UserEntity userModel);

    Optional<UserModel> findUser(UserModel User);

    void remove(UserModel userModel);

    List<UserModel> getAllUsers();

}
