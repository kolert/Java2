package lv.javaguru.java2.views.Mail;

import lv.javaguru.java2.businesslogic.Mail.UpdateMailService;
import lv.javaguru.java2.businesslogic.Products.UpdateProductService;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateMailView implements View {

    @Autowired
    private UpdateMailService updateMailService;

    @Override
    public Object get(Object model) throws InvalidDataException{
        return null;
    }
    @Override
    public void execute(Object model) throws InvalidDataException {
        updateMailService.update(model);
    }
}
