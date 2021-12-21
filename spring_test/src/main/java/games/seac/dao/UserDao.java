package games.seac.dao;

import games.seac.domain.Role;
import games.seac.domain.User;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/11/23 - 11:44
 */
public interface UserDao {
    List<User> findAll();


    long save(User user);

    void saveUserRoleRel(Long userId, Long[] roleIds);

    void delUserRoleRel(long userId);

    void del(long userId);

    User findByUserNameAndPassword(String username, String password);
}
