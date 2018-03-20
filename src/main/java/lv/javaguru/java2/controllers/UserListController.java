package lv.javaguru.java2.controllers;

import lv.javaguru.java2.database.Users.UserDatabase;
import lv.javaguru.java2.database.Users.UserInMemoryDatabase;
import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.Users.ShowUserListView;
import lv.javaguru.java2.views.View;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Scope("session")
public class UserListController {
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String registeUser(HttpServletRequest request, HttpSession session, Model model) {
        try {
            //UserDatabase database = new UserInMemoryDatabase();
            View showProductView = new ShowUserListView();
            model.addAttribute("users", showProductView.get(null));
        }catch(InvalidDataException e){
            System.out.println(e.getMessage());
        }
        return "user/userList";
    }
}
