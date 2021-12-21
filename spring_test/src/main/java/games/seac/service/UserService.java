package games.seac.service;

import games.seac.domain.User;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/11/23 - 11:42
 */
public interface UserService {
    List<User> list();

    void save(User user, Long[] roleIds);

    void del(long userId);

    User login(String username, String password);
}
