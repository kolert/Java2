package lv.javaguru.java2.businesslogic.Mail;

import lv.javaguru.java2.database.Entities.Mail;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.repositorys.MailRepository;
import lv.javaguru.java2.database.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AddMailService {

    @Autowired
    private MailRepository mailRepository;

    @Transactional
    public void addMail(Mail mail) {
        mailRepository.save(mail);
    }

}
