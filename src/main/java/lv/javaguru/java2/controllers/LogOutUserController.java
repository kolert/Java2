package lv.javaguru.java2.controllers;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Scope("session")
public class LogOutUserController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String home(HttpServletRequest request,HttpSession session, Model model) {
        session.removeAttribute("auth");
        session.removeAttribute("userName");
        return "redirect:/login";
    }
}

