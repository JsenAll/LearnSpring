package com.itheima.fuctory;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceimpl_NEW;
import com.itheima.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;


/**
 * 基于接口的代理增强类
 */
public class BeanFuctory {
    /**
     * 被代理的对象
     */
    private AccountServiceimpl_NEW accountServiceimpl_new;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountServiceimpl_new(AccountServiceimpl_NEW accountServiceimpl_new) {
        this.accountServiceimpl_new = accountServiceimpl_new;
    }

    public IAccountService getAccountService() {
        IAccountService invocationHandler = (IAccountService) Proxy.newProxyInstance
                (accountServiceimpl_new.getClass().getClassLoader(), accountServiceimpl_new.getClass().getInterfaces()
                        , new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                Object iAccountService = null;
                                try {
                                    //1.开启事务
                                    txManager.beginTransaction();
                                    //2.执行操作
                                    iAccountService = method.invoke(accountServiceimpl_new, args);
                                    //3.提交事务
                                    txManager.commit();
                                    //4.返回结果
                                    return iAccountService;
                                } catch (Exception e) {
                                    //5.回滚操作
                                    System.out.println("回滚操作");
                                    txManager.rollback();
                                    throw new RuntimeException(e);
                                } finally {
                                    //6.释放连接
                                    txManager.release();
                                }
                            }
                        });


        return invocationHandler;
    }

}
