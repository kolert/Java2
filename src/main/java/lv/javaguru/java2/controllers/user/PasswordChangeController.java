package lv.javaguru.java2.controllers.user;


import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.functions.PasswordFunctions;
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
import java.util.Optional;

@Scope("session")
@Controller
public class PasswordChangeController {

    @RequestMapping(value = "/passwordChange", method = RequestMethod.GET)
    public String dispayUser(HttpServletRequest request, Model model) {
        return "user/changePassword";
    }
    @RequestMapping(value = "/passwordChange", method = RequestMethod.POST)
    public RedirectView registeUser(HttpServletRequest request, HttpSession session,
                                    Model model,RedirectAttributes redirectAttributes) {
        String password = request.getParameter("password");
        String repPassword = request.getParameter("repPassword");
        String oldPassword = request.getParameter("oldPassword");
        boolean success = true;
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        if (!password.equals(repPassword)){
            success = false;
            redirectAttributes.addFlashAttribute("error", "Entered passwords are not equal! Please try again.");
        }
        if(!success){
            redirectView.setUrl("/passwordChange");
            return redirectView;
        }
        Optional<User> user = null;
        User tempUser =(User) session.getAttribute("user");
        tempUser.setPassword(oldPassword);
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        user = applicationContext.getBean(FindUserView.class).get(tempUser);
        if (user.isPresent()) {
            User userModel = user.get();
            try {
                if (PasswordFunctions.check(oldPassword, userModel.getPassword())){
                    userModel.setPassword(password);
                    applicationContext.getBean(UpdateUserView.class).execute(userModel);
                }else{
                    success = false;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(!success){
            redirectView.setUrl("/passwordChange");
            return redirectView;
        }
        redirectView.setUrl("/");
        return redirectView;
    }
}

