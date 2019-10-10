package com.itheima.jdbctemplate;

import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 使用 ioc 进行crud
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");

        AccountDaoImpl jt = applicationContext.getBean("accountDao", AccountDaoImpl.class);

        Account accountById = jt.findAccountById(2);
        System.out.println(accountById);

        Account jhs = jt.findAccountByName("a");
        System.out.println(jhs);

        jhs.setMoney(70000f);
        jt.updateAccount(jhs);//更新


    }
}
