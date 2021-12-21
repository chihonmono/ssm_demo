package games.seac.dao.impl;

import games.seac.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Honmono
 * @date 2021/11/16 - 14:44
 */
//<bean id="userDao" class="games.seac.dao.impl.UserDaoImpl"></bean>
//@Component("userDao") //可以应用在任一层级
@Repository("userDao") //等效@Component，应用在dao层，提高可读性
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running...");
    }
}
