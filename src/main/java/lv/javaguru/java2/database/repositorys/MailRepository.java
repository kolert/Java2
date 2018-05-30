package lv.javaguru.java2.database.repositorys;

import lv.javaguru.java2.database.Entities.Mail;
import lv.javaguru.java2.database.Entities.Product;

import java.util.List;
import java.util.Optional;

public interface MailRepository {

    void save(Mail mail);
    void remove(Mail mail);
    void update(Mail mail);
    List<Mail> findMails(Mail mail);
    Optional<Mail> findMail(Mail mail);
}
