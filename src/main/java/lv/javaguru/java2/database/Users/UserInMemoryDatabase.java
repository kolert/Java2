package lv.javaguru.java2.database.Users;

import lv.javaguru.java2.database.Entities.UserEntity;
import lv.javaguru.java2.models.Product;
import lv.javaguru.java2.models.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserInMemoryDatabase implements UserDatabase {

    private static List<UserEntity> users = new ArrayList<>();

    @Override
    public void add(UserEntity userModel) {
        users.add(entityToModel(userModel));
    }

    @Override
    public Optional<UserEntity> findUser(UserModel user) {
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
    public List<UserModel> getAllUsers() {
        List<UserModel> allUsers = new ArrayList<>();
        //allUsers.addAll(users);
        return allUsers;
    }

    private UserEntity entityToModel(UserEntity userEntity){
        UserEntity userModel = new UserEntity();
        userModel.setId(userEntity.getId());
        userModel.setLogin(userEntity.getLogin());
        userModel.setPassword(userEntity.getPassword());
        userModel.setName(userEntity.getName());
        userModel.setSurname(userEntity.getSurname());
        userModel.setRole(userEntity.getRole());
        userModel.setStatus(userEntity.getStatus());
        return userModel;
    }
}
