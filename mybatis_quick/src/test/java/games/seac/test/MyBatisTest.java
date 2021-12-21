package games.seac.test;

import games.seac.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @author Honmono
 * @date 2021/12/5 - 10:37
 */
public class MyBatisTest {

    //更新操作
    @Test
    public void test4() throws IOException {

        //模拟user对象
        User user = new User();
        user.setId(7);
        user.setUsername("lucy");
        user.setPassword("abcde");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数：namespace+id
        sqlSession.delete("userMapper.delete",7);

        //mybatis事务默认不提交，执行更新操作，需要手动提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    //更新操作
    @Test
    public void test3() throws IOException {

        //模拟user对象
        User user = new User();
        user.setId(7);
        user.setUsername("lucy");
        user.setPassword("abcde");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数：namespace+id
        sqlSession.update("userMapper.update", user);

        //mybatis事务默认不提交，执行更新操作，需要手动提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    //插入操作
    @Test
    public void test2() throws IOException {

        //模拟user对象
        User user = new User();
        user.setUsername("tom");
        user.setPassword("abc");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数：namespace+id
        sqlSession.insert("userMapper.save", user);

        //mybatis事务默认不提交，执行更新操作，需要手动提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    //查询操作
    @Test
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //释放资源
        sqlSession.close();
    }

}
