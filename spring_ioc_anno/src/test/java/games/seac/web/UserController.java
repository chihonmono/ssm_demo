package games.seac.web;

import games.seac.config.SpringConfiguration;
import games.seac.service.UserService;

/**
 * @author Honmono
 * @date 2021/11/16 - 14:51
 */

public class UserController {
    public static void main(String[] args) {
        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
