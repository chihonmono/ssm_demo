package games.seac.service;

import games.seac.domain.Role;

import java.util.*;

/**
 * @author Honmono
 * @date 2021/11/22 - 11:49
 */
public interface RoleService {
    public List<Role> list();

    void save(Role role);
}
