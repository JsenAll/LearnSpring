package com.itheima.service.impl;

import com.itheima.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class AccountServiceImplTest {


    @Test
    public void findAllAccount() {
        //1:获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2:得到业务层对象
        AccountServiceImpl accountService = (AccountServiceImpl) applicationContext.getBean("accountService");
        List<Account> allAccount = accountService.findAllAccount();
        System.out.println(allAccount);

    }


    @Test
    public void findAccountById() {
        //1:获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2:得到业务层对象
        AccountServiceImpl accountService = (AccountServiceImpl) applicationContext.getBean("accountService");
        Account accountById = accountService.findAccountById(1);
        System.out.println(accountById);
    }

    @Test
    public void saveAccount() {
        //1:获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2:得到业务层对象
        AccountServiceImpl accountService = (AccountServiceImpl) applicationContext.getBean("accountService");
        Account account = new Account();
        account.setId(1);
        account.setName("jsh");
        account.setMoney((float) 5000000.00);
        accountService.saveAccount(account);
    }

    @Test
    public void updateAccount() {
        //1:获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2:得到业务层对象
        AccountServiceImpl accountService = (AccountServiceImpl) applicationContext.getBean("accountService");
        Account account = new Account();
        account.setId(1);
        account.setName("jsh");
        account.setMoney((float) 500000000.00);
        accountService.updateAccount(account);
    }

    @Test
    public void deleteAccount() {
        //1:获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2:得到业务层对象
        AccountServiceImpl accountService = (AccountServiceImpl) applicationContext.getBean("accountService");
        accountService.deleteAccount(6);
    }
}