package lv.javaguru.java2.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Scope("session")
public class ErrorController {
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public RedirectView error(HttpServletRequest request, HttpSession session, Model model) {
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(false);
        redirectView.setUrl("/");
        model.addAttribute("error","Oops! Something went wrong!");
        return redirectView;
    }
}
