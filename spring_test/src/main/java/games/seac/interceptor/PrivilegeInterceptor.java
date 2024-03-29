package games.seac.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Honmono
 * @date 2021/11/24 - 12:00
 */
public class PrivilegeInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //逻辑：判断用户是否登录 判断session中有没有user
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null){
            //没有登录
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
        //放行 访问目标资源
        return true;
    }
}
