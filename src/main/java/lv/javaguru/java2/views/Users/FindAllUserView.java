package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.businesslogic.users.FindUserService;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FindAllUserView implements View {

    @Autowired
    private FindUserService findUserService;

    @Override
    public List<User> get(Object user) {
        return findUserService.getAllUsers();
    }
    @Override
    public void execute(Object model) throws InvalidDataException{
    }

}
