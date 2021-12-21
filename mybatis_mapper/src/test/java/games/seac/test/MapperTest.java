package games.seac.test;

import games.seac.domain.User;
import games.seac.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Honmono
 * @date 2021/12/11 - 9:16
 */
public class MapperTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟条件 真实情况是从web层封装并传递过来
        User condition = new User();
        condition.setId(1);
        condition.setUsername("zhangsan");
        condition.setPassword("123");

        List<User> userList = mapper.findByCondition(condition);

        System.out.println(userList);

        System.out.println("===");

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        List<User> userList2 = mapper.findByIds(ids);
        System.out.println(userList2);
    }
}
