package lv.javaguru.java2.controllers.user;


import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.Mail;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.Products.AddProductView;
import lv.javaguru.java2.views.Users.FindUserView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Scope("session")
@Controller
public class SendMailController {

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String dispayUser(HttpServletRequest request, Model model) {
        return "user/mail_form";
    }
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public RedirectView addServiceView(HttpServletRequest request, HttpSession session ,
                                       RedirectAttributes redirectAttributes, Model model){
        String recipiant = request.getParameter("recLogin");
        String message = request.getParameter("mail_message");

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        User recUser = new User();
        recUser.setLogin(recipiant);
        Optional<User> recModel = applicationContext.getBean(FindUserView.class).get(recUser);
        if(recModel.isPresent()) {
            User sender = (User) session.getAttribute("user");
            Mail mail = new Mail();
            mail.setRecipientId(recModel.get().getId());
            mail.setSenderId(sender.getId());
            mail.setMessage(message);
            try {
                applicationContext.getBean(AddProductView.class).execute(mail);
            }catch(Exception e){
                e.printStackTrace();
            }
            redirectView.setUrl("/sendMail");
        }else{
            model.addAttribute("error","No such recipiant found!");
            redirectView.setUrl("/contact");
        }
        return redirectView;
    }
}

