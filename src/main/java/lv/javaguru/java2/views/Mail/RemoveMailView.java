package lv.javaguru.java2.views.Mail;

import lv.javaguru.java2.businesslogic.Mail.RemoveMailService;
import lv.javaguru.java2.database.Entities.Mail;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveMailView implements View {

    @Autowired
    private RemoveMailService removeMailService;


    @Override
    public void execute(Object model) throws InvalidDataException {
        removeMailService.removeProduct((Mail) model);
    }

    @Override
    public String get(Object model) throws InvalidDataException {
        return null;
    }
}
