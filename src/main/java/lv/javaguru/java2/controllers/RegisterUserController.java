package lv.javaguru.java2.controllers;


import lv.javaguru.java2.database.Products.ProductDatabase;
import lv.javaguru.java2.database.Products.ProductInMemoryDatabase;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.database.Users.UserInMemoryDatabase;
import lv.javaguru.java2.models.UserModel;
import lv.javaguru.java2.views.Products.AddProductView;
import lv.javaguru.java2.views.Products.ProgramExitView;
import lv.javaguru.java2.views.Products.RemoveProductView;
import lv.javaguru.java2.views.Products.ShowProductListView;
import lv.javaguru.java2.views.Users.AddUserView;
import lv.javaguru.java2.views.Users.ShowUserListView;
import lv.javaguru.java2.views.View;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Scope("session")
@Controller
public class RegisterUserController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String dispayUser(HttpServletRequest request,Model model) {
        return "user/registration";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registeUser(HttpServletRequest request,Model model) {
        model.addAttribute("h1Text","Text from controller");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String repPassword = request.getParameter("repPassword");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");

        UserModel userModel = new UserModel();
        userModel.setLogin(login);
        userModel.setPassword(password);
        userModel.setName(name);
        userModel.setSurname(surname);
        userModel.setEmail(email);

        //TODO createUser


        UserDatabase database = new UserInMemoryDatabase();

        View addUserView = new AddUserView(database);
        addUserView.execute(userModel);

        View showProductView = new ShowUserListView(database);
        //TODO getUser
        model.addAttribute("users",showProductView.get());
        return "user/userList";
    }
}

