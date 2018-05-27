package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.Users.UserDatabase;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
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
@Rollback(false)
@Repository
public abstract class OrmTest {

    //@Autowired private JDBCDatabase database;

    @Autowired
    @Qualifier("userRepository")
    protected UserDatabase userRepository;

    @Before
    public void init(){};

    protected User saveUser(String name, String surname, String login, String password, String email, char role, char status) {
        User user = new User();

        user.setName("name");
        user.setSurname("surname");
        user.setLogin("login");
        user.setPassword("password");
        user.setCreated(new java.sql.Timestamp((new Date()).getTime()));
        user.setEmail("email");
        user.setRole('U');
        user.setStatus('A');

        assertNull(user.getLogin());
        userRepository.add(user);
        assertNotNull(user.getLogin());

        return user;
    }

}
