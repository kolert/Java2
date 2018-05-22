package lv.javaguru.java2.controllers.user;

import lv.javaguru.java2.businesslogic.users.FindUserService;
import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.views.Users.AddUserView;
import lv.javaguru.java2.views.Users.FindAllUserView;
import lv.javaguru.java2.views.Users.FindUserView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Scope("session")
@Controller
public class UserListController {
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String registeUser(HttpServletRequest request, HttpSession session, Model model) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        List<User> userList = applicationContext.getBean(FindAllUserView.class).get(null);
        model.addAttribute("users", userList);
        return "user/userList";
    }
}
