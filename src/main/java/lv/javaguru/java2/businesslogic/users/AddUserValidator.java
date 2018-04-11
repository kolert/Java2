package lv.javaguru.java2.businesslogic.users;

import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.businesslogic.helper.Error;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddUserValidator {

    private int maxCharacters = 2;

    public static List<Error> validate(String login, String name, String surname, String email) {
        List<Error> errors = new ArrayList<>();
        validateLogin(login).ifPresent(errors::add);
        validateName(name).ifPresent(errors::add);
        validateSurname(surname).ifPresent(errors::add);
        validateEmail(email).ifPresent(errors::add);
        return errors;
    }

    private static Optional<Error> validateLogin(String login) {
        if((login != null && !login.isEmpty()) && login.matches("[A-Za-z0-9_]+") && login.getBytes(StandardCharsets.UTF_8).length > 2) {
            return Optional.empty();
        } else {
            return Optional.of(new Error("login", "Login cannot contain 0 symbols"));
        }
    }

    private static Optional<Error> validateName(String name) {
        if((name != null || !name.isEmpty()) && name.matches("[A-Z][a-zA-Z]*") && name.getBytes(StandardCharsets.UTF_8).length > 2) {
            return Optional.empty();
        } else {
            return Optional.of(new Error("name", "Name cannot contain 0 symbols"));
        }
    }

    private static Optional<Error> validateSurname(String surname) {
        if((surname != null || !surname.isEmpty()) && surname.matches("[a-zA-z]+([ '-][a-zA-Z]+)*") && surname.getBytes(StandardCharsets.UTF_8).length > 2) {
            return Optional.empty();
        } else {
            return Optional.of(new Error("surname", "Surname cannot contain 0 symbols"));
        }
    }

    private static Optional<Error> validateEmail(String email) {
        if((email != null || !email.isEmpty()) && email.matches("^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$") && email.getBytes(StandardCharsets.UTF_8).length > 2) {
            return Optional.empty();
        } else {
            return Optional.of(new Error("email", "Email cannot contain 0 symbols"));
        }
    }
}
