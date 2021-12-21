package games.seac.resolver;

import games.seac.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Honmono
 * @date 2021/11/24 - 15:44
 */
public class MyExceptionResolver implements HandlerExceptionResolver {


    /*
        参数Exception:异常对象
        返回值ModelAndView:跳转到错误视图信息
     */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof MyException){
            modelAndView.addObject("info","自定义异常");
        }else if (e instanceof ClassCastException){
            modelAndView.addObject("info","类转换异常");
        }

        modelAndView.setViewName("error");
        return modelAndView;
    }
}
