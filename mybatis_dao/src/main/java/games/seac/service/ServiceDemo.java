package games.seac.service;

import games.seac.dao.UserMapper;
import games.seac.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Honmono
 * @date 2021/12/9 - 15:37
 */
public class ServiceDemo {
    public static void main(String[] args) throws IOException {
        //加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取sqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法1 无参
        List<User> all = mapper.findAll();
        System.out.println(all);
        //调用方法2 有参
        User userById = mapper.findById(1);
        System.out.println(userById);
    }
}
