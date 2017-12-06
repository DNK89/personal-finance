package lv.dnk89.personalfinance.mvc;

import lv.dnk89.personalfinance.configs.SpringAppConfig;
import lv.dnk89.personalfinance.mvc.controllers.HomeController;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MVCDispatcher implements Filter {

    public static final String ROUTE_TO_HOME = "/home";
    private static Logger logger = Logger.getLogger(MVCDispatcher.class.getName());

    private ApplicationContext applicationContext;
    private Map<String, MVCController> controllers;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            applicationContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        } catch (BeansException e) {
            logger.log(Level.WARNING, "Spring context failed to start", e);
        }

        controllers = new HashMap<>();
        controllers.put(ROUTE_TO_HOME, getControllerBean(HomeController.class));
    }

    private MVCController getControllerBean(Class controllerClass){
        return (MVCController) applicationContext.getBean(controllerClass);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String contextURI = request.getServletPath();

        if (controllers.containsKey(contextURI)) {

            MVCController controller = controllers.get(contextURI);

            MVCModel model = null;

            String httpMethod = request.getMethod();

            if ("GET".equalsIgnoreCase(httpMethod)) {
                model = controller.processGet(request);
            }
            if ("POST".equalsIgnoreCase(httpMethod)) {
                model = controller.processPost(request);
            }

            request.setAttribute("model", model.getData());

            ServletContext context = request.getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getView());
            requestDispatcher.forward(request, response);

        } else {
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
