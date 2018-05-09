package lv.javaguru.java2.database.Users;

import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.models.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserInMemoryDatabase implements UserDatabase {

    private static List<User> users = new ArrayList<>();

    @Override
    public void add(User userModel) {
        users.add(entityToModel(userModel));
    }

    @Override
    public Optional<User> findUser(UserModel user) {
/*
        for (Product product : products) {
            if (product.getTitle().equals(title)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
*/
        return users.stream()
                .filter(u -> u.getLogin().equals(user.getLogin()))
                .findFirst();
    }

    @Override
    public void remove(UserModel userModel) {
        users.remove(userModel);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        //allUsers.addAll(users);
        return allUsers;
    }

    private User entityToModel(User userEntity){
        User userModel = new User();
        userModel.setId(userEntity.getId());
        userModel.setLogin(userEntity.getLogin());
        userModel.setPassword(userEntity.getPassword());
        userModel.setName(userEntity.getName());
        userModel.setSurname(userEntity.getSurname());
        userModel.setRole(userEntity.getRole().charAt(0));
        userModel.setStatus(userEntity.getStatus());
        return userModel;
    }
}
