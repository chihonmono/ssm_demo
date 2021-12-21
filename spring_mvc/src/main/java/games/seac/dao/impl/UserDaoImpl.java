package games.seac.dao.impl;

import games.seac.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author Honmono
 * @date 2021/11/16 - 14:44
 */
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running...");
    }
}
