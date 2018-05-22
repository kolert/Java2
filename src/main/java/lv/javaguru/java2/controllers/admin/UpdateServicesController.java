package lv.javaguru.java2.controllers.admin;


import lv.javaguru.java2.businesslogic.helper.Error;
import lv.javaguru.java2.businesslogic.users.AddUserValidator;
import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.functions.PasswordFunctions;
import lv.javaguru.java2.views.Products.FindProductView;
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
public class UpdateServicesController {

    @RequestMapping(value = "/updateservice", method = RequestMethod.GET)
    public String addServiceView(HttpServletRequest request, Model model) {
        return "user/updateservice";
    }
    @RequestMapping(value = "/updateservice", method = RequestMethod.POST)
    public RedirectView addServiceView(HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String imgUrl = request.getParameter("imgUrl");

        boolean success = true;
        RedirectView redirectView = new RedirectView();

        Optional<Product> product = null;
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        product = applicationContext.getBean(FindProductView.class).get(title);

        if(!success){
            redirectView.setUrl("/updateservice");
            return redirectView;
        }
        redirectView.setUrl("/services");
        return redirectView;
    }
}
