package games.seac.dao;

import games.seac.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * dao层接口方法实现
 * 条件：
 * 命名空间对应接口全限定名
 * 方法名对应配置id
 * 方法类型对应配置类型
 * 参数类型对应配置参数类型
 *
 * 实现原理：MyBatis通过动态代理的方法自动创建实现
 *
 *
 * @author Honmono
 * @date 2021/12/9 - 15:13
 */
public interface UserMapper {
    public List<User> findAll() throws IOException;

    public User findById(int id);
}
