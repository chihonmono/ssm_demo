package games.seac.test;

import games.seac.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/11/21 - 15:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //改
    @Test
    public void testUpdate(){
        jdbcTemplate.update("update account set money = ? where name = ?",10000,"zhangsan");
    }

    //删
    @Test
    public void testDelete(){
        jdbcTemplate.update("DELETE from account where name = ?","zhangsan");
    }

    //查所有
    @Test
    public void testQueryAll(){
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    //查一个
    @Test
    public void testQueryOne(){
        Account a = jdbcTemplate.queryForObject("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), "tom");
        System.out.println(a);
    }

    //查总数
    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }

}
