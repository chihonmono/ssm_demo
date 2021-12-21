package games.seac.factory;

import games.seac.dao.UserDao;
import games.seac.dao.impl.UserDaoImpl;

/**
 * @author Honmono
 * @date 2021/11/15 - 12:46
 */
public class DynamicFactory {

    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
