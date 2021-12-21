package games.seac.service.impl;

import games.seac.dao.UserDao;
import games.seac.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Honmono
 * @date 2021/11/15 - 12:54
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    //set方法依赖注入
    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/


    //构造方法依赖注入
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    public void save() {
        userDao.save();
    }
}
