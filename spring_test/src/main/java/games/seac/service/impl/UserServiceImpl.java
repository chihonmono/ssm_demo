package games.seac.service.impl;

import games.seac.dao.RoleDao;
import games.seac.dao.UserDao;
import games.seac.domain.Role;
import games.seac.domain.User;
import games.seac.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/11/23 - 11:43
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<User> list() {
        List<User> userList = userDao.findAll();
        //封装userList中的每一个user的roles数据
        for (User user : userList) {
            Long id = user.getId();
            //将id作为参数，查询当前userID对应的role的集合数据
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    public void save(User user, Long[] roleIds) {
        //第一步 向sys_user表存储数据
        long userId = userDao.save(user);
        //第二步 向sys_user_role表存储多条数据
        userDao.saveUserRoleRel(userId,roleIds);
    }

    public void del(long userId) {
        //1、删除sys_user_role关系表 先删除关系表数据，否则会因为外键约束无法删除主表数据
        userDao.delUserRoleRel(userId);
        //2、sys_user表
        userDao.del(userId);
    }

    public User login(String username, String password) {
        try {
            User user = userDao.findByUserNameAndPassword(username, password);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
