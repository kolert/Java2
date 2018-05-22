package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.repositorys.UserRepository;
import lv.javaguru.java2.models.UserModel;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class UserORM extends ORMRepository
        implements UserRepository {

    @Override
    public void remove(User userModel){
        session().delete(userModel);
    }
    @Override
    public void update(User userModel) { session().update(userModel);}
    @Override
    public Optional<User> findUser(User userModel){
        System.out.println("findUsers");
        System.out.println(userModel.getLogin());
        String login = userModel.getLogin();
        User user = (User) session().createCriteria(User.class)
                .add(Restrictions.eq("login",login))
                .uniqueResult();
        return Optional.ofNullable(user);

    }
    @Override
    public List<User> getAllUsers() {
        return session()
                .createCriteria(User.class)
                .list();
    }

    @Override
    public void save(User user) {
            session().save(user);
    }
}
