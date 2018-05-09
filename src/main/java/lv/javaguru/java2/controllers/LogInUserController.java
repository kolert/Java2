package lv.javaguru.java2.controllers;


import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.functions.PasswordFunctions;
import lv.javaguru.java2.models.UserModel;
import lv.javaguru.java2.views.Users.FindAllUserView;
import lv.javaguru.java2.views.Users.FindUserView;
import lv.javaguru.java2.views.View;
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

@Controller
@Scope("session")
public class LogInUserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String home(HttpServletRequest request,HttpSession session, Model model) {
        return "user/login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String onPost(HttpServletRequest request, HttpSession session, Model model) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Optional<User> user = null;
        User tempUser = new User();
        tempUser.setLogin(login);
        tempUser.setPassword(password);
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        user = applicationContext.getBean(FindUserView.class).get(tempUser);
        if (user.isPresent()) {
            User userModel = user.get();
            try {
                if (PasswordFunctions.check(password, userModel.getPassword())){
                    request.getSession(true);
                    session.setAttribute("auth", true);
                    session.setAttribute("user", userModel);
                    if(userModel.getRole().equals("A")){
                        session.setAttribute("sideBar","active");
                    }
                    return "redirect:/userList";
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "user/login";
    }
}

