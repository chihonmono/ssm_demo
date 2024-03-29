package games.seac.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import games.seac.domain.User;
import games.seac.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author Honmono
 * @date 2021/12/11 - 10:22
 */
public class MybatisTest {
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //创建user
        User user = new User();
        user.setUsername("ceshi");
        user.setPassword("123");
        user.setBirthday(new Date());

        //执行保存
        mapper.save(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.findById(6);
        System.out.println(user.getBirthday());

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //设置分页相关参数 当前页 每页显示条数
        PageHelper.startPage(1,3);

        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        //获取与分页相关的参数
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页显示条目数:" + pageInfo.getPageSize());
        System.out.println("总条目数:"+pageInfo.getTotal());
        System.out.println("上一页:"+pageInfo.getPrePage());
        System.out.println("下一页:"+pageInfo.getNextPage());
        System.out.println("是否是第一页:"+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页:"+pageInfo.isIsLastPage());


        sqlSession.commit();
        sqlSession.close();
    }
}
