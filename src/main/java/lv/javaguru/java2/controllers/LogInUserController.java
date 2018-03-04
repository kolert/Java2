package lv.javaguru.java2.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogInUserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String home(HttpServletRequest request,Model model) {
        return "user/login";
    }
}

