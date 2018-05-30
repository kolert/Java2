package lv.javaguru.java2.views.Mail;

import lv.javaguru.java2.businesslogic.Mail.FindMailService;
import lv.javaguru.java2.database.Entities.Mail;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowMailListView implements View {

    @Autowired
    private FindMailService findMailService;

    @Override
    public List<Mail> get(Object model) {
        return findMailService.findMails((Mail) model);
    }
    @Override
    public void execute(Object model) throws InvalidDataException {
    }
}
