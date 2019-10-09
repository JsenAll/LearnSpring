package com.itheima.jdbctemplate;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate CRUD
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1:获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2:获取对象
        JdbcTemplate jt = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        //3:执行操作
        //3.1保存,添加
//        int eee = jt.update("insert into account (name,money) value(?,?)", "eee", 333f);
//        System.out.println((eee == 1) ? "成功" : "失败");
        //3.2 更新
//        int text = jt.update("update account set name=?,money=? where id=?", "text", 101010, 1);
//        System.out.println((text == 1) ? "成功" : "失败");
        //3.3 删除
//        int update = jt.update("delete from account where id=?", 10);
//        System.out.println((update == 1) ? "成功" : "失败");
        //        jt.execute("insert into  account (name,money) value ('jhsjhs' ,20000)");
        //3.4 查询所有
        //自己定义封装策略 new AccountRowMapper()
//        List<Account> query = jt.query("select * from account", new AccountRowMapper());

        //将查询出来的结果进行封装 可以减少account的分装策略 BeanPropertyRowMapper<Account>(Account.class)
//        List<Account> query1 = jt.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
//        List<Account> query2 = jt.query("select * from account where money>?", new BeanPropertyRowMapper<Account>(Account.class), 10);
//        System.out.println(query2);

        //3.5 查询一个
//                List<Account> accounts = jt.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),5000000);
//        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));
        //3.6 查询返回一行一列（使用聚合函数，但不加group by子句） 查询有多少大于1000的人
        Long count = jt.queryForObject("select count(*) from account where money > ?", Long.class, 1000f);
        System.out.println(count);

    }


}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account> {
    /**
     * 把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     *
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}