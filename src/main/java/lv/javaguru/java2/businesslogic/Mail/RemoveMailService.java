package lv.javaguru.java2.businesslogic.Mail;

import lv.javaguru.java2.database.Entities.Mail;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.repositorys.MailRepository;
import lv.javaguru.java2.exceptions.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class RemoveMailService {

    @Autowired
    private MailRepository mailRepository;

    @Transactional
    public void removeProduct(Mail mail) throws InvalidDataException {
        Mail mailModel = (Mail) mail;
        System.out.println("started removing");
        System.out.println(mail.toString());
        Optional<Mail> foundProduct = mailRepository.findMail(mailModel);
        if (foundProduct.isPresent()) {
            mailModel = foundProduct.get();
            try {
                mailRepository.remove(mailModel);
                System.out.println("Product removed!");
            }catch(Exception e){
                e.printStackTrace();
            }
        } else {
            throw new InvalidDataException("Product does not exists!");
        }
    }

}
