package games.seac.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.rowset.internal.Row;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * @author Honmono
 * @date 2021/11/21 - 14:42
 */
public class JdbcTemplateTest {

    @Test
    //测试JdbcTemplateTest开发步骤
    public void test1() throws PropertyVetoException {
        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///test");
        dataSource.setUser("root");
        dataSource.setPassword("honmono");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象
        jdbcTemplate.setDataSource(dataSource);

        //执行操作
        jdbcTemplate.update("insert into account values(?,?)","tom",5000);

    }

    @Test
    //测试Spring产生JdbcTemplate对象
    public void test2() throws PropertyVetoException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        //执行操作
        int row = jdbcTemplate.update("insert into account values(?,?)", "zhangsan", 5000);
        System.out.println(row);
    }
}
