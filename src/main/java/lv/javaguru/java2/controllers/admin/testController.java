package lv.javaguru.java2.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Set;

@Controller
@Scope("session")
public class testController {
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @RequestMapping( value = "/endPoints", method = RequestMethod.GET )
    public String getEndPointsInView( Model model )
    {
        Set endpoints = requestMappingHandlerMapping.getHandlerMethods().keySet();
        model.addAttribute( "endPoints", endpoints);
        return "admin/endPoints";
    }
}
