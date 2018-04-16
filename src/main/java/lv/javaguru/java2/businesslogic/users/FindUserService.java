package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.database.repositorys.UserRepository;
import lv.javaguru.java2.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class FindUserService {
    @Autowired
    private UserRepository userORMDatabase;
    @Transactional
    public Optional<User> findUser(Object model) {
        Optional<User> foundUser = userORMDatabase.findUser((User)model);
        return foundUser;
    }
    @Transactional
    public List<User> getAllUsers() {
        List<User> allUsers = userORMDatabase.getAllUsers();
        return allUsers;
    }

}
