package games.seac.demo;

import games.seac.service.UserService;
import games.seac.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟web层
 * @author Honmono
 * @date 2021/11/15 - 12:58
 */
public class UserContoller {
    public static void main(String[] args) {
        //UserService service = new UserServiceImpl();
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
