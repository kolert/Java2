package lv.javaguru.java2.controllers.admin;


import lv.javaguru.java2.businesslogic.helper.Error;
import lv.javaguru.java2.businesslogic.users.AddUserValidator;
import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.views.Users.AddUserView;
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
public class AddUserController {

    @RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
    public String dispayUser(HttpServletRequest request, Model model) {
        return "admin/user_add";
    }
    @RequestMapping(value = "/admin/addUser", method = RequestMethod.POST)
    public RedirectView registeUser(HttpServletRequest request, HttpSession session,
                                    Model model,RedirectAttributes redirectAttributes) {
        model.addAttribute("h1Text","Text from controller");
        String login = request.getParameter("login");
        String password = login;
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");
        String status = request.getParameter("status");
        User userModel = new User();
        userModel.setLogin(login);
        userModel.setPassword(password);
        userModel.setName(name);
        userModel.setSurname(surname);
        userModel.setEmail(email);
        userModel.setPhone(phone);
        userModel.setStatus(status.charAt(0));
        userModel.setRole(role.charAt(0));

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);

        List<Error> validatorRespose = AddUserValidator.validate(userModel.getLogin(),userModel.getName(),userModel.getSurname(),userModel.getEmail());

        boolean success = true;

//        if (success) {
//            List<String> errormsg = new ArrayList<>();
//            for (Error error : validatorRespose) {
//                System.out.println(error.toString());
//                if (error.getField() != null) {
//                    success = false;
//                    errormsg.add(error.getMessage());
//                }
//            }
//            redirectAttributes.addFlashAttribute("errorlist", errormsg);
//        }

        if(success) {
            try {
                ApplicationContext applicationContext
                        = new AnnotationConfigApplicationContext(SpringAppConfig.class);
                applicationContext.getBean(AddUserView.class).execute(userModel);
            } catch (Exception e) {
                success = false;
                System.out.println(e);
            }
        }
        if (success == false){
            redirectView.setUrl("/admin/userAdd");
        }
        else {
            redirectView.setUrl("/admin/userList");
        }
        return redirectView;
    }
}

