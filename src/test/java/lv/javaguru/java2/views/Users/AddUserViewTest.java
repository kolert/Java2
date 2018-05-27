package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.businesslogic.responses.Response;
import lv.javaguru.java2.businesslogic.users.AddUserService;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

public class AddUserViewTest {

    @Mock private UserDatabase userDatabase;
    @Mock private AddUserService service;

    @Test
    public void shoudlBeErrorWhenLoginEmpty() {
        User user = Mockito.mock(User.class);
        user.setName("test");
        user.setSurname("test");
        user.setPassword("testPass");
        user.setEmail("testEmail");

        Mockito.when(userDatabase.findUser(user)).thenReturn(Optional.empty());

        Response response = null;
        try {
            response = service.addUser(user);
        }catch(InvalidDataException e){
        }

        assertEquals(response.isSuccess(),false);
        assertEquals(response.getError().getField(),"login");
        assertEquals(response.getError().getField(),"name");
        assertEquals(response.getError().getField(),"surname");
        assertEquals(response.getError().getMessage(), "Can not be empty!");
    }

    @Test
    public void execute() {
    }
}