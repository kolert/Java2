package lv.javaguru.java2.database.Users;

import lv.javaguru.java2.database.Entities.UserEntity;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.models.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserORMDatabase implements UserDatabase{

    @Autowired
    private SessionFactory sessionFactory;

    private Session session(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(UserEntity user){
        session().save(user);
    }
    @Override
    public void remove(UserModel userModel){
        session().delete(userModel);
    }
    @Override
    public List<UserModel> getAllUsers(){
        List<UserModel> ret = new ArrayList<>();
        return ret;
    }
    @Override
    public Optional<UserEntity> findUser(UserModel userModel){
        System.out.println("findUsers");
        System.out.println(userModel.getLogin());
        String login = userModel.getLogin();
        UserEntity user = (UserEntity) session().createCriteria(UserEntity.class)
                .add(Restrictions.eq("login",login))
                .uniqueResult();
        return Optional.ofNullable(user);

    }
}
