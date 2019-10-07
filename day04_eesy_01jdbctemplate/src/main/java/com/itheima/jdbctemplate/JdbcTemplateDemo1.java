package com.itheima.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate 最基本的用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源 :spring 内置的数据源
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy");
        ds.setUsername("root");
        ds.setPassword("jhs123");
        //创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        //执行操作
        jdbcTemplate.execute("insert into account(name,money)value ('asdasd',10000)");
    }
}
