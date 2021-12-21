package games.seac.factory;

import games.seac.dao.UserDao;
import games.seac.dao.impl.UserDaoImpl;

/**
 * @author Honmono
 * @date 2021/11/15 - 12:41
 */
public class StaticFactory {

    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
