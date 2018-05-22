package lv.javaguru.java2.views.Users;

import lv.javaguru.java2.businesslogic.users.UpdateUserService;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserView implements View {

    @Autowired
    private UpdateUserService updateUserService;

    @Override
    public Object get(Object model) throws InvalidDataException{
        return null;
    }
    @Override
    public void execute(Object model) throws InvalidDataException {
        updateUserService.update(model);
    }

}
