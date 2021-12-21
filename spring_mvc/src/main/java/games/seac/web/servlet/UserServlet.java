package games.seac.web.servlet; /**
 * @author Honmono
 * @date 2021/11/17 - 11:13
 */

import games.seac.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        //ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        UserService userService = (UserService) app.getBean(UserService.class);
        userService.save();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
