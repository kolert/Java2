package lv.javaguru.java2.database.repositorys;

import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);
    void update(User userModel);
    void remove(User userModel);
    List<User> getAllUsers();
    Optional<User> findUser(User userModel);
}
