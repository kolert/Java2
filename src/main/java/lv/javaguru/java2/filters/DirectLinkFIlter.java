package lv.javaguru.java2.filters;

import lv.javaguru.java2.config.SpringAppConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirectLinkFIlter implements Filter {
    private static Logger logger = Logger.getLogger(DirectLinkFIlter.class.getName());

    private ApplicationContext applicationContext;
    private List<String> endpointList;

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    public DirectLinkFIlter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        ApplicationContext applicationContext
//                = new AnnotationConfigApplicationContext(ContextRefreshedEvent.class);
//        Map endpointMap = applicationContext.getBean(RequestMappingHandlerMapping.class).getHandlerMethods();
//        for(Object key : endpointMap.keySet()){
//            System.out.println(key);
//        }
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String contextURI = req.getServletPath();

        if (false){//requestMappingHandlerMapping.getHandlerMethods().keySet().contains(contextURI)){
            ServletContext context = req.getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(contextURI);
            requestDispatcher.forward(req, resp);
        }
        else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
