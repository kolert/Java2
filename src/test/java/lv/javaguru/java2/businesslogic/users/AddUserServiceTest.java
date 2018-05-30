package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.database.Entities.User;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class AddUserServiceTest extends OrmTestOne {
    @Autowired
    private FindUserService findUserService;

    @Test
    public void addUserTest() throws Exception {
        User user1 = addUser("name", "surname", "login", "password","email", 'U', 'A', "22222222");
        Optional<User> found = findUserService.findUser(user1);
        assertTrue(String.valueOf((found.isPresent())), true);
    }

}