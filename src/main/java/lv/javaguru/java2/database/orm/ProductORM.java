package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.database.repositorys.ProductRepository;
import lv.javaguru.java2.database.repositorys.UserRepository;
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
        String title = product.getTitle();
        Product ret = (Product) session().createCriteria(Product.class)
                .add(Restrictions.eq("title",title))
                .uniqueResult();
        return Optional.ofNullable(ret);

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
