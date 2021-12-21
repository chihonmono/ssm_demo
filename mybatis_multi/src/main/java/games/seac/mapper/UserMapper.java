package games.seac.mapper;

import games.seac.domain.User;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/12/12 - 10:15
 */
public interface UserMapper {
    public List<User> findAll();

    public List<User> findUserAndRoleAll();
}
