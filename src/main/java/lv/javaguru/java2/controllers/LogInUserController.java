package lv.javaguru.java2.controllers;


import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.database.Users.UserInMemoryDatabase;
import lv.javaguru.java2.excetions.InvalidDataException;
import lv.javaguru.java2.models.UserModel;
import lv.javaguru.java2.views.Users.FindUserView;
import lv.javaguru.java2.views.Users.ShowUserListView;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Scope("session")
public class LogInUserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String home(HttpServletRequest request,Model model) {
        return "user/login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView onPost(HttpServletRequest request, HttpServletResponse response, Model model) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Optional<UserModel> user = null;
        try {
            UserDatabase database = new UserInMemoryDatabase();
            View findUserView = new FindUserView(database);
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
                request.getSession().setAttribute("authorized",true);
                request.getSession().setAttribute("user",userModel.getName());
                return new RedirectView("/userList");
            }
        }
        return new RedirectView("/login");
    }
}

