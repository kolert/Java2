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
public class UpdateMailService {

    @Autowired
    private MailRepository mailRepository;
    @Transactional
    public void update(Object model) throws InvalidDataException {
        Mail productModel = (Mail) model;
        System.out.println("started update");
        System.out.println(model.toString());
        Optional<Mail> foundProduct = mailRepository.findMail(productModel);
        if (foundProduct.isPresent()) {
            productModel = foundProduct.get();
            try {
                productModel.setMessage(((Mail)model).getMessage());
                mailRepository.update(productModel);
                System.out.println("User updated");
            }catch(Exception e){
                e.printStackTrace();
            }
        } else {
            throw new InvalidDataException("Product does not exists!");
        }
    }

}
