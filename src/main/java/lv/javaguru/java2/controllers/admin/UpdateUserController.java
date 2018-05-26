package lv.javaguru.java2.controllers.admin;


import lv.javaguru.java2.businesslogic.helper.Error;
import lv.javaguru.java2.businesslogic.users.AddUserValidator;
import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.views.Users.AddUserView;
import lv.javaguru.java2.views.Users.FindUserView;
import lv.javaguru.java2.views.Users.UpdateUserView;
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
public class UpdateUserController {

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String dispayUserEdit(HttpServletRequest request, Model model) {
        User userModel = new User();
        userModel.setId(Long.parseLong(request.getParameter("ref")));
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        Optional<User> user=applicationContext.getBean(FindUserView.class).get(userModel);
        model.addAttribute("user",user.get());
        model.addAttribute("action","edit");
        return "admin/user_add";
    }
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public RedirectView updateUser(HttpServletRequest request, HttpSession session,
                                    Model model,RedirectAttributes redirectAttributes) {
        model.addAttribute("h1Text","Text from controller");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String status = request.getParameter("status");
        User userModel = new User();
        userModel.setName(name);
        userModel.setSurname(surname);
        userModel.setEmail(email);
        userModel.setStatus(status.charAt(0));

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);

        boolean success = true;
        try {
            ApplicationContext applicationContext
                    = new AnnotationConfigApplicationContext(SpringAppConfig.class);
            Optional<User> foundUser = applicationContext.getBean(FindUserView.class).get(userModel);
            if(foundUser.isPresent()) {
                userModel.setLogin(foundUser.get().getLogin());
                userModel.setPassword(foundUser.get().getPassword());
                userModel.setRole(foundUser.get().getRole().charAt(0));
                applicationContext.getBean(UpdateUserView.class).execute(userModel);
            }else{
                success = false;
            }
        } catch (Exception e) {
            success = false;
            System.out.println(e);
        }
        if (success == false){
            redirectView.setUrl("/updateUser");
        }
        else {
            redirectView.setUrl("/userList");
        }
        return redirectView;
    }
}

