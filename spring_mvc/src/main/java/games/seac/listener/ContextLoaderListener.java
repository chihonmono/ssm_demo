package games.seac.listener;

import games.seac.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

/**
 * 通过ContextLoaderListener监听服务器启动
 * 在服务器启动时获取ApplicationContext对象
 * 并保存到ServletContext域
 * 以后每次使用从域中获取对象，无需每次使用都读取配置文件获取对象，减少开销
 * @author Honmono
 * @date 2021/11/17 - 11:43
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获取servletContext
        ServletContext servletContext = servletContextEvent.getServletContext();
        //读取web.xml中的全局参数:spring配置文件名 解耦合
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //获取Spring应用上下文对象
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        //将对象存储到ServletContext域
        servletContext.setAttribute("app", app);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
