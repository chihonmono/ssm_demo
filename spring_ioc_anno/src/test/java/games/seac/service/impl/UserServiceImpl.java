package games.seac.service.impl;

import games.seac.dao.UserDao;
import games.seac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author Honmono
 * @date 2021/11/16 - 14:45
 */
/*
    <bean id="userService" class="games.seac.service.impl.UserServiceImpl">
        <property name="userDao" ref="userDao"></property>
    </bean>
 */
//@Component("userService") //可以应用在任一层级
@Service("userService") //等效@Component，应用在service层，提高可读性
//@Scope("singleton")
//@Scope("prototype")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String driver;

    @Autowired //按照数据类型从spring容器中进行匹配
    @Qualifier("userDao") //按照id值从容器中进行匹配 但是要结合@Autowired一起使用

    //@Resource(name = "userDao") //相当于@Autowired+@Qualifier

    private UserDao userDao;

    //使用注解方式可以省略sertter方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct //初始化方法
    public void init(){
        System.out.println("service init...");
    }

    @PreDestroy //销毁方法
    public void destroy(){
        System.out.println("service destroy...");
    }
}
