package lv.javaguru.java2.businesslogic.validators;

import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.businesslogic.helper.Error;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddUserValidator {

    private UserDatabase userDatabase;
    private int maxCharacters = 2;

    public AddUserValidator(UserDatabase userDatabase){
        this.userDatabase = userDatabase;
    }

    public List<Error> validate(String login) {
        List<Error> errors = new ArrayList<>();
        validateLogin(login).ifPresent(errors::add);
        return errors;
    }

    private Optional<Error> validateLogin(String login) {
        if((login == null || login.isEmpty()) && login.matches("[A-Za-z0-9_]+") && login.getBytes(StandardCharsets.UTF_8).length <= this.maxCharacters) {
            return Optional.of(new Error("login", "Login cannot contain 0 symbols"));
        } else {
            return Optional.empty();
        }
    }
}
