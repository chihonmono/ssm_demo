package games.seac.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @author Honmono
 * @date 2021/11/17 - 12:01
 */
public class WebApplicationContextUtils {

    public static ApplicationContext getWebApplicationContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }

}
