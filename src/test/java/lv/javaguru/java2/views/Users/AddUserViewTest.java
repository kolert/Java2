package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.businesslogic.users.AddUserService;
import lv.javaguru.java2.businesslogic.responses.UserResponse;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.models.UserModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

public class AddUserViewTest {

    private UserDatabase userDatabase;
    private AddUserService service;

    @Before
    public void init(){
        userDatabase = Mockito.mock(UserDatabase.class);
        service = new AddUserService(userDatabase, null);
    }
    @Test
    public void shoudlBeErrorWhenLoginEmpty() {
        UserModel user = Mockito.mock(UserModel.class);
        user.setName("test");
        user.setSurname("test");
        user.setPassword("testPass");
        user.setEmail("testEmail");

        Mockito.when(userDatabase.findByLogin("test")).thenReturn(Optional.empty());

        UserResponse response = null;
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