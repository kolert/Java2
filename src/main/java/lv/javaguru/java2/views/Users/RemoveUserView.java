package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.businesslogic.users.RemoveUserService;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveUserView implements View {
    @Autowired
    private RemoveUserService removeUserService;

    @Override
    public void execute(Object login) throws InvalidDataException {
        removeUserService.removeUser((String)login);
    }

    @Override
    public Object get(Object model) throws InvalidDataException {
        return null;
    }
}
