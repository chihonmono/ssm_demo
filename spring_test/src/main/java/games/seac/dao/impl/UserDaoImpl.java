package games.seac.dao.impl;

import games.seac.dao.UserDao;
import games.seac.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Honmono
 * @date 2021/11/23 - 11:45
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    public long save(final User user) {
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //使用原始jdbc完成一个PreparedStatement的组件
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(null,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,user.getUsername());
                preparedStatement.setObject(2,user.getEmail());
                preparedStatement.setObject(3,user.getPassword());
                preparedStatement.setObject(4,user.getPhoneNum());
                return preparedStatement;
            }
        };
        //创建keyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
        //获得生成的主键
        long userId = keyHolder.getKey().longValue();
        return userId; //返回数据库自动生成的主键id
    }

    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?,?)",userId,roleId);
        }
    }

    public void delUserRoleRel(long userId) {
    jdbcTemplate.update("delete from sys_user_role where userId = ?",userId);
    }

    public void del(long userId) {
    jdbcTemplate.update("delete from sys_user where id = ?",userId);
    }

    public User findByUserNameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        /*
            queryForObject在查询不到数据是会报异常，直接将其抛出，在service层处理
         */
        User user = jdbcTemplate.queryForObject("select * from sys_user where username = ? and password = ?", new BeanPropertyRowMapper<User>(User.class), username, password);
        return user;
    }
}
