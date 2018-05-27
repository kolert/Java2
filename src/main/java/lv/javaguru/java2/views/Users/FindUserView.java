package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.businesslogic.users.FindUserService;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class FindUserView implements View {

    @Autowired
    private FindUserService findUserService;

    @Override
    public Optional<User> get(Object user) {
        return findUserService.findUser(((User) user));
    }
    @Override
    public void execute(Object model) throws InvalidDataException{
    }

}
