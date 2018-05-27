package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.repositorys.UserRepository;
import org.hibernate.Criteria;
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
    public void update(User userModel) { session().saveOrUpdate(userModel);}
    @Override
    public Optional<User> findUser(User userModel){
        System.out.println("findUsers");
        System.out.println(userModel.getLogin());
        Criteria hql = session().createCriteria(User.class);
        if(userModel.getId()!=null&&userModel.getId()!=0)
            hql.add(Restrictions.eq("id",userModel.getId()));
        if(userModel.getLogin()!=null&&!userModel.getLogin().isEmpty())
            hql.add(Restrictions.eq("login",userModel.getLogin()));
        User user =(User) hql.uniqueResult();
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
