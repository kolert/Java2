package lv.javaguru.java2.controllers.user;


import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.Mail;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.views.Mail.FindMailView;
import lv.javaguru.java2.views.Mail.ShowMailListView;
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
import java.util.List;
import java.util.Optional;

@Scope("session")
@Controller
public class GetSendMailController {

    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public String sendMailList(HttpServletRequest request, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Mail mailModel = new Mail();
        mailModel.setSenderId(user.getId());
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        List<Mail> mailList = applicationContext.getBean(ShowMailListView.class).get(mailModel);
        model.addAttribute("mailList",mailList);
        return "user/send_mail_list";
    }
}

