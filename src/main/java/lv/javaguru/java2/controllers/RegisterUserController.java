package lv.javaguru.java2.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterUserController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String dispayUser(HttpServletRequest request,Model model) {
        return "user/register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registeUser(HttpServletRequest request,Model model) {
        model.addAttribute("h1Text","Text from controller");
        return "user/register";
    }
}

