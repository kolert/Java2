package lv.javaguru.java2.businesslogic.Mail;

import lv.javaguru.java2.database.Entities.Mail;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.repositorys.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class FindMailService {
    @Autowired
    private MailRepository mailRepository;
    @Transactional
    public Optional<Mail> findMail(Mail model) {
        Optional<Mail> foundUser = mailRepository.findMail(model);
        return foundUser;
    }
    @Transactional
    public List<Mail> findMails(Mail mail) {
        List<Mail> allProducts = mailRepository.findMails(mail);
        return allProducts;
    }

}
