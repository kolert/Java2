package lv.javaguru.java2.businesslogic.validators;

import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.businesslogic.helper.Error;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddUserValidator {

    private UserDatabase userDatabase;

    public AddUserValidator(UserDatabase userDatabase){
        this.userDatabase = userDatabase;
    }

    public List<Error> validate(String login) {
        List<Error> errors = new ArrayList<>();
        validateLogin(login).ifPresent(errors::add);
        return errors;
    }

    private Optional<Error> validateLogin(String login) {
        if(login == null || login.isEmpty()) {
            return Optional.of(new Error("login", "Login cannot contain 0 symbols"));
        } else {
            return Optional.empty();
        }
    }
}
