package games.seac.mapper;

import games.seac.domain.User;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/12/11 - 9:11
 */
public interface UserMapper {
    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> ids);



}
