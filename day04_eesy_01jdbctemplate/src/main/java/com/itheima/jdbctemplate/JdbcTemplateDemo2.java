package com.itheima.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        jt.execute("insert into  account (name,money) value ('jhsjhs' ,20000)");
    }
}
