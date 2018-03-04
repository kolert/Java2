package lv.javaguru.java2.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Scope("session")
@Controller
public class RegisterUserController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String dispayUser(HttpServletRequest request,Model model) {
        return "user/registration";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registeUser(HttpServletRequest request,Model model) {
        model.addAttribute("h1Text","Text from controller");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String repPassword = request.getParameter("repPassword");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        Map<String,String> userMap = new HashMap<>();
        userMap.put("login",login);
        userMap.put("password",password);
        userMap.put("repPassword",repPassword);
        userMap.put("name",name);
        userMap.put("surname",surname);
        userMap.put("email",email);

        List<Map<String,String>> users = (List<Map<String,String>>) request.getSession().getAttribute("users");
        if(users!=null){
            users.add(userMap);
        }else{
            users = new ArrayList<>();
            users.add(userMap);
            request.getSession().setAttribute("users",users);
        }
        //TODO createUser

        //TODO getUser
        model.addAttribute("users",users);
        return "user/userList";
    }
}
