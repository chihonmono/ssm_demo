package games.seac.test;

import games.seac.config.SpringConfiguration;
import games.seac.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Honmono
 * @date 2021/11/16 - 16:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml") //使用配置文件
@ContextConfiguration(classes = {SpringConfiguration.class}) //使用全注解开发
public class SpringJunitTest {

    @Autowired(required = false)
    private UserService userService;

    @Test
    public void test1() {
        userService.save();
    }
}
