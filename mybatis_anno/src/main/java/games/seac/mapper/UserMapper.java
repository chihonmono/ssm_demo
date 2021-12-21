package games.seac.mapper;

import games.seac.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/12/14 - 13:59
 */
public interface UserMapper {

    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public void save(User user);

    @Update("update user set username=#{username},password=#{password},birthday=#{birthday}")
    public void update(User user);

    @Delete("delete from user where id=#{id}")
    public void delete(int id);

    @Select("select * from user where id=#{id}")
    public User findById(int id);

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "games.seac.mapper.OrderMapper.findByUid")
            )
    })
    public List<User> findUserAndOrderAll();

    @Select("select * from user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "games.seac.mapper.RoleMapper.findRoleByUid")
            )
    })
    public List<User> findUserAndRoleAll();

}
