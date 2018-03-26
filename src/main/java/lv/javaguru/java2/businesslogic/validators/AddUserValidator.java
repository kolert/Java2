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

    public List<Error> validate(String login, String name, String surname) {
        List<Error> errors = new ArrayList<>();
        validateLogin(login).ifPresent(errors::add);
        validateName(name).ifPresent(errors::add);
        validateSurname(surname).ifPresent(errors::add);
        return errors;
    }

    private Optional<Error> validateLogin(String login) {
        if((login == null || login.isEmpty()) && login.matches("[A-Za-z0-9_]+") && login.getBytes(StandardCharsets.UTF_8).length <= this.maxCharacters) {
            return Optional.of(new Error("login", "Login cannot contain 0 symbols"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateName(String name) {
        if((name == null || name.isEmpty()) && name.matches("[A-Z][a-zA-Z]*") && name.getBytes(StandardCharsets.UTF_8).length <= this.maxCharacters) {
            return Optional.of(new Error("name", "Name cannot contain 0 symbols"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateSurname(String surname) {
        if((surname == null || surname.isEmpty()) && surname.matches("[a-zA-z]+([ '-][a-zA-Z]+)*") && surname.getBytes(StandardCharsets.UTF_8).length <= this.maxCharacters) {
            return Optional.of(new Error("surname", "Surname cannot contain 0 symbols"));
        } else {
            return Optional.empty();
        }
    }
}
