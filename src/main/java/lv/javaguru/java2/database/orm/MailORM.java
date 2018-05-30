package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.Entities.Mail;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.repositorys.MailRepository;
import lv.javaguru.java2.database.repositorys.ProductRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class MailORM extends ORMRepository
        implements MailRepository {

    @Override
    public void save(Mail mail) {
        session().save(mail);
    }

    @Override
    public void remove(Mail mail){
        session().delete(mail);
    }

    @Override
    public void update(Mail mail) {
        session().saveOrUpdate(mail);
    }
    @Override
    public Optional<Mail> findMail(Mail mail){
        Criteria hql = session().createCriteria(Mail.class);
        if(mail.getId()!=null&&mail.getId()!=0)
            hql.add(Restrictions.eq("id",mail.getId()));
        else {
            if (mail.getSenderId() != null && mail.getSenderId()!=0)
                hql.add(Restrictions.eq("sender_id", mail.getSenderId()));
            if (mail.getRecipientId() != null && mail.getRecipientId()!=0)
                hql.add(Restrictions.eq("recipient_id", mail.getRecipientId()));
        }
        Mail mailModel =(Mail) hql.uniqueResult();
        return Optional.ofNullable(mailModel);
    }
    @Override
    public List<Mail> findMails(Mail mail){
        List<Mail> ret = new ArrayList<>();
        Criteria hql = session().createCriteria(Mail.class);
        if(mail.getId()!=null&&mail.getId()!=0)
            hql.add(Restrictions.eq("id",mail.getId()));
        else {
            if (mail.getSenderId() != null && mail.getSenderId()!=0)
                hql.add(Restrictions.eq("senderId", mail.getSenderId()));
            if (mail.getRecipientId() != null && mail.getRecipientId()!=0)
                hql.add(Restrictions.eq("recipientId", mail.getRecipientId()));
        }
        ret = hql.list();
        return ret;
    }
}
