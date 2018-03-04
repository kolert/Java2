package lv.javaguru.java2.controllers;


import lv.javaguru.java2.lessons.Product;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "homeController")
@ELBeanName(value = "homeController")
@Join(path = "/", to = "/views/home/main.jsf")
public class HomeController {

    @Autowired
    private Product product = new Product();

    public String save() {
        product = new Product();
        return "/product-list.xhtml?faces-redirect=true";
    }

    public Product getProduct() {
        return product;
    }
}

