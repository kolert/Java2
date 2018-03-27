package lv.javaguru.java2.database.Users;

import lv.javaguru.java2.models.Product;
import lv.javaguru.java2.models.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserInMemoryDatabase implements UserDatabase {

    private static List<UserModel> users = new ArrayList<>();

    @Override
    public void add(UserModel userModel) {
        users.add(userModel);
    }

    @Override
    public Optional<UserModel> findByLogin(String login) {
/*
        for (Product product : products) {
            if (product.getTitle().equals(title)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
*/
        return users.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst();
    }

    @Override
    public Optional<UserModel> findByName(String name) {
        return users.stream()
                .filter(u -> u.getName().equals(name))
                .findFirst();
    }

    @Override
    public Optional<UserModel> findBySurname(String surname) {
        return users.stream()
                .filter(u -> u.getName().equals(surname))
                .findFirst();
    }

    @Override
    public Optional<UserModel> findByEmail(String email) {
        return users.stream()
                .filter(u -> u.getName().equals(email))
                .findFirst();
    }

    @Override
    public void remove(UserModel userModel) {
        users.remove(userModel);
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> allUsers = new ArrayList<>();
        allUsers.addAll(users);
        return allUsers;
    }

}
