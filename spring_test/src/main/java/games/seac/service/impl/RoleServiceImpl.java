package games.seac.service.impl;

import games.seac.dao.RoleDao;
import games.seac.domain.Role;
import games.seac.service.RoleService;
import javafx.scene.input.RotateEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author Honmono
 * @date 2021/11/22 - 11:51
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();

        return roleList;
    }

    public void save(Role role) {
        roleDao.save(role);
    }
}
