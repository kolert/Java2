package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.businesslogic.users.RemoveUserService;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;

public class RemoveUserView implements View {

    private RemoveUserService removeUserService;

    public RemoveUserView(UserDatabase database) {
        this.removeUserService = new RemoveUserService(database);
    }
    @Override
    public void execute(Object login) throws InvalidDataException {
        removeUserService.removeUser((String)login);
    }

    @Override
    public Object get(Object model) throws InvalidDataException {
        return null;
    }
}
