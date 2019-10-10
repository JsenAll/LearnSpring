package com.itheima.service.impl;

import com.itheima.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class AccountServiceimpl_NEWTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("bean.xml");
        IAccountService proxyAccountService = applicationContext.getBean("accountService", IAccountService.class);
        proxyAccountService.transfer("bbb","ccc",1000f);
    }
}