package lv.javaguru.java2.controllers;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@Scope("session")
public class AboutUsController {

    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    public String home(HttpServletRequest request,Model model) {
        return "user/aboutus";
    }
}

