package lv.javaguru.java2.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Starting Page";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest request,Model model) {
        return "home";
    }
}

