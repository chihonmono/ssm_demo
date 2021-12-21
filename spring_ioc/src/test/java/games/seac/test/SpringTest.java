package games.seac.test;

import games.seac.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Honmono
 * @date 2021/11/15 - 11:39
 */
public class SpringTest {

    //测试scope属性
    @Test
    public void test1(){
        //获取ApplicationContext对象
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取两个UserDao
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        /*
          若两个UserDao对象地址相同则为单一对象
          singleton:一样
          prototype:不一样
        */
        System.out.println(userDao1);
        System.out.println(userDao2);
    }
}
