package lv.javaguru.java2.controllers;


import lv.javaguru.java2.businesslogic.helper.Error;
import lv.javaguru.java2.businesslogic.responses.UserResponse;
import lv.javaguru.java2.businesslogic.validators.AddUserValidator;
import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.database.Users.UserInMemoryDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.models.UserModel;
import lv.javaguru.java2.views.Users.AddUserView;
import lv.javaguru.java2.views.View;
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

@Scope("session")
@Controller
public class RegisterUserController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String dispayUser(HttpServletRequest request,Model model) {
        return "user/registration";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public RedirectView registeUser(HttpServletRequest request, HttpSession session,
                                    Model model,RedirectAttributes redirectAttributes) {
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
        userModel.setStatus("A");
        userModel.setRole("U");
//        TODO model validator
//        AddUserValidator validator = new AddUserValidator();
//        List<Error> validatorRespose = validator.validate(userModel.getLogin(),userModel.getName(),userModel.getSurname(),userModel.getEmail());
        boolean success = true;

        try {
            ApplicationContext applicationContext
                    = new AnnotationConfigApplicationContext(SpringAppConfig.class);
            applicationContext.getBean(AddUserView.class).execute(userModel);
        }catch(Exception e){
            success = false;
            System.out.println(e.getMessage());
        }
        return new RedirectView("/login");
    }
}

