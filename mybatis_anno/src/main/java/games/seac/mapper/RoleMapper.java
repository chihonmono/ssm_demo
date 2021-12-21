package games.seac.mapper;

import games.seac.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/12/14 - 16:06
 */
public interface RoleMapper {

    @Select("select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=#{uid}")
    public List<Role> findRoleByUid(int uid);
}
