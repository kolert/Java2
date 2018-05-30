package lv.javaguru.java2.views.Mail;

import lv.javaguru.java2.businesslogic.Mail.AddMailService;
import lv.javaguru.java2.database.Entities.Mail;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddMailView implements View {

    @Autowired
    private AddMailService addMailService;

    @Override
    public void execute(Object model) throws InvalidDataException {

        addMailService.addMail((Mail) model);
        System.out.println("Product added!");
    }
    @Override
    public Object get(Object model) throws InvalidDataException{
        return null;
    }

}
