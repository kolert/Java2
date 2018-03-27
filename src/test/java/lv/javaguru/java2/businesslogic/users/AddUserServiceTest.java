package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.businesslogic.responses.UserResponse;
import lv.javaguru.java2.businesslogic.validators.AddUserValidator;
import lv.javaguru.java2.businesslogic.helper.Error;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.models.UserModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddUserServiceTest {

    private UserDatabase database;
    private AddUserValidator validator;
    private AddUserService service;

    @Before
    public void init(){
        database = Mockito.mock(UserDatabase.class);
        validator = Mockito.mock(AddUserValidator.class);
        service = new AddUserService(database, validator);
    }

    @Test
    public void addUserTest() throws Exception {
        List<Error> errors = new ArrayList<>();
        Mockito.when(validator.validate("login", "name", "surname", "email")).thenReturn(errors);
        UserModel model = new UserModel();
        model.setLogin("login");
        model.setName("name");
        model.setSurname("surname");
        model.setEmail("email");
        UserResponse response = service.addUser(model);
        assertEquals(response.isSuccess(), true);
        assertEquals(response.getError(), null);
    }

}