package games.seac.dao;

import games.seac.domain.Role;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/11/22 - 11:56
 */
public interface RoleDao {
    List<Role> findAll();

    void save(Role role);


    List<Role> findRoleByUserId(Long id);
}
