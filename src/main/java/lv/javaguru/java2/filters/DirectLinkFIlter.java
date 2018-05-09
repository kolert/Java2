package lv.javaguru.java2.filters;

import lv.javaguru.java2.database.Entities.User;
import lv.javaguru.java2.models.UserModel;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Component
public class DirectLinkFIlter implements Filter {
    private static Logger logger = Logger.getLogger(DirectLinkFIlter.class.getName());

    private List<String> endpointList;

    public DirectLinkFIlter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String contextURI = req.getServletPath();

        ServletContext context = req.getServletContext();
        HttpSession session = req.getSession();
        if ("/userList".contains(contextURI)){
            RequestDispatcher requestDispatcher = null;
            if(session.getAttribute("auth")==null || !session.getAttribute("auth").equals(true)) {
                requestDispatcher = context.getRequestDispatcher("/");
                requestDispatcher.forward(req,resp);
            }
        }
        if("/endPoints".contains(contextURI)){
            RequestDispatcher requestDispatcher = null;
            if(session.getAttribute("auth")==null || !session.getAttribute("auth").equals(true) ||
                    !((User)session.getAttribute("user")).getRole().equals("A")) {
                requestDispatcher = context.getRequestDispatcher("/");
                requestDispatcher.forward(req,resp);
            }
        }


        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }

    public List<String> getEndpointList() {
        return endpointList;
    }

    public void setEndpointList(List<String> endpointList) {
        this.endpointList = endpointList;
    }
}
