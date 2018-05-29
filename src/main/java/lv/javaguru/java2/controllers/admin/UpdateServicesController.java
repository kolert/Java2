package lv.javaguru.java2.controllers.admin;


import lv.javaguru.java2.businesslogic.helper.Error;
import lv.javaguru.java2.businesslogic.users.AddUserValidator;
import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.functions.PasswordFunctions;
import lv.javaguru.java2.views.Products.FindProductView;
import lv.javaguru.java2.views.Products.UpdateProductView;
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

    @RequestMapping(value = "/admin/updateService", method = RequestMethod.GET)
    public String addServiceView(HttpServletRequest request, Model model) {
        Product productModel = new Product();
        productModel.setId(Long.parseLong(request.getParameter("ref")));
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        Optional<Product> product=applicationContext.getBean(FindProductView.class).get(productModel);
        model.addAttribute("product", product.get());
        model.addAttribute("action","edit");
        return "admin/addservice";
    }
    @RequestMapping(value = "/admin/updateService", method = RequestMethod.POST)
    public RedirectView addServiceView(HttpServletRequest request, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("h1Text","Text from controller");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String imgUrl = request.getParameter("imgUrl");
        Product productModel = new Product();
        productModel.setId(Long.parseLong(request.getParameter("ref")));
        productModel.setTitle(title);
        productModel.setDescription(description);
        productModel.setImgUrl(imgUrl);

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);

        boolean success = true;

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        try {
            applicationContext.getBean(UpdateProductView.class).execute(productModel);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

        if (success == false){
            redirectView.addStaticAttribute("ref",request.getParameter("ref"));
            redirectView.setUrl("/admin/updateService");
        }
        else {
            redirectView.setUrl("/services");
        }
        return redirectView;
    }
}

