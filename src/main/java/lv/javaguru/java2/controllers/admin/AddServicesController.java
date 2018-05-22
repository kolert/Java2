package lv.javaguru.java2.controllers.admin;


import lv.javaguru.java2.businesslogic.helper.Error;
import lv.javaguru.java2.businesslogic.users.AddUserValidator;
import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.Product;
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
public class AddServicesController {

    @RequestMapping(value = "/addservice", method = RequestMethod.GET)
    public String dispayUser(HttpServletRequest request, Model model) {
        return "admin/addservice";
    }
    @RequestMapping(value = "/addservice", method = RequestMethod.POST)
    public RedirectView addServiceView(HttpServletRequest request, HttpSession session ,RedirectAttributes redirectAttributes) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String imgUrl = request.getParameter("imgUrl");

        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImgUrl(imgUrl);

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);

        //List<Error> validatorRespose = AddUserValidator.validate(product.getTitle(),product.getDescription(),product.getImgUrl());

        return redirectView;
    }
}

