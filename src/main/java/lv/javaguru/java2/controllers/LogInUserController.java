package lv.javaguru.java2.controllers;


import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.database.Users.UserInMemoryDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.models.UserModel;
import lv.javaguru.java2.views.Users.FindUserView;
import lv.javaguru.java2.views.View;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        Optional<UserModel> user = null;
        try {
            View findUserView = new FindUserView();
            System.out.println(login);
            user =(Optional<UserModel>) findUserView.get(login);
        }catch(InvalidDataException e){
            System.out.println(e.getMessage());
        }
        System.out.println(user.toString());
        if (user.isPresent()) {
            UserModel userModel = user.get();
            if (userModel.getPassword().equals(password)) {
                request.getSession(true);
                session.setAttribute("auth",true);
                session.setAttribute("userName",userModel.getName());
                return "redirect:/userList";
            }
        }
        return "user/login";
    }
}

