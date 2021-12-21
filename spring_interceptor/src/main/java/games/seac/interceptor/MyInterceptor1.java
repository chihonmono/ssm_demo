package games.seac.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Honmono
 * @date 2021/11/24 - 11:17
 */
public class MyInterceptor1 implements HandlerInterceptor {
    //在目标方法执行之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre...");
        String param = request.getParameter("param");
        if ("yes".equals(param)){
            return true;
        }else {
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return false;
        }
    }
    //在目标方法执行之后 视图返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post...");
        modelAndView.addObject("name","honmono");
    }
    //在流程执行完毕后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after...");
    }
}
