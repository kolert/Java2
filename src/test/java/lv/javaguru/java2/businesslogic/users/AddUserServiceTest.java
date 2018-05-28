package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.database.Entities.User;

import org.junit.Test;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class AddUserServiceTest extends OrmTestOne {

    @Test
    public void addUserTest() throws Exception {
        User user1 = saveUser("name", "surname", "login", "password","email", 'U', 'A');
        Optional<User> found = userRepository.findUser(user1);
        assertTrue(found.isPresent());
    }

}