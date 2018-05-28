package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringAppConfig.class })
@Transactional
@Rollback(true)
public abstract class OrmTestOne {

//    @Autowired
//    protected UserDatabase userRepository;

    @Autowired
    protected AddUserService addUserService;

    @Before
    public void init(){};

    protected User addUser(String name, String surname, String login, String password, String email, char role, char status) {
        User user = new User();

        user.setName("name");
        user.setSurname("surname");
        user.setLogin("login");
        user.setPassword("password");
        user.setCreated(new java.sql.Timestamp((new Date()).getTime()));
        user.setEmail("email");
        user.setRole('U');
        user.setStatus('A');

        try {
            addUserService.addUser(user);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

        assertNotNull(user.getId());
        assertNotNull(user.getName());
        assertNotNull(user.getSurname());
        assertNotNull(user.getLogin());
        assertNotNull(user.getPassword());
        assertNotNull(user.getEmail());
        assertNotNull(user.getRole());
        assertNotNull(user.getStatus());

        return user;
    }

}
