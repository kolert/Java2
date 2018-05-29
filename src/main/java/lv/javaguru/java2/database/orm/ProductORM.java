package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.repositorys.ProductRepository;
import lv.javaguru.java2.database.repositorys.UserRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class ProductORM extends ORMRepository
        implements ProductRepository {

    @Override
    public void remove(Product product){
        session().delete(product);
    }

    @Override
    public void update(Product product) {
        session().saveOrUpdate(product);
    }
    @Override
    public Optional<Product> findProduct(Product product){
        Criteria hql = session().createCriteria(User.class);
        if(product.getId()!=null&&product.getId()!=0)
            hql.add(Restrictions.eq("id",product.getId()));
        if(product.getTitle()!=null&&!product.getTitle().isEmpty())
            hql.add(Restrictions.eq("title",product.getTitle()));
        Product user =(Product) hql.uniqueResult();
        return Optional.ofNullable(user);
    }
    @Override
    public List<Product> getAllProducts() {
        return session()
                .createCriteria(Product.class)
                .list();
    }

    @Override
    public void save(Product product) {
            session().save(product);
    }
}
