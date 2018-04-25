package lv.javaguru.java2.controllers;


import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Entities.Product;
import lv.javaguru.java2.views.Products.ShowProductListView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Scope("session")
public class ServicesController {

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpSession session, Model model) {

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        List<Product> productList = applicationContext.getBean(ShowProductListView.class).get(null);
        model.addAttribute("products", productList);
        return "user/services";
    }
}

