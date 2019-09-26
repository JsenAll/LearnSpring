package com.itheima.cglib;

import com.itheima.proxy.IProducer;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    Producer producer = new Producer();

    public static void main(String[] args) {
//        new Client().noProxy();
        new Client().yesProxy();
    }

    /**
     * 没有使用动态代理
     */
    public void noProxy() {
        System.out.println("没有使用动态代理");
        producer.saleProduct(100f);
    }

    /**
     * 动态代理：
     * 特点：字节码随用随创建，随用随加载
     * 作用：不修改源码的基础上对方法增强
     * 分类：
     *      基于接口的动态代理
     *      基于子类的动态代理
     * 基于子类的动态代理：
     *      涉及的类：Enhancer
     *      提供者：第三方cglib库
     *      如何创建代理对象：
     *          使用Enhancer类中的create方法
     *      创建代理对象的要求：
     *          被代理类不能是最终类
     * create方法的参数：
     *      Class：字节码
     *       它是用于指定被代理对象的字节码。
     * <p>
     *      Callback：用于提供增强的代码
     *      它是让我们写如何代理。我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
     *      此接口的实现类都是谁用谁写。
     * 我们一般写的都是该接口的子接口实现类：MethodInterceptor
     */
    public void yesProxy() {
        Producer producer1 = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
             * @param o 代理对象的引用
             * @param method 当前执行的方法
             * @param objects 当前执行方法所需的参数
             * @param methodProxy ：当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //提供增强的代码
                Object returnValue = null;

                //1.获取方法执行的参数
                Float money = (Float) objects[0];
                //2.判断当前方法是不是销售
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                System.out.println( methodProxy.getSuperName());
                return returnValue;
            }
        });
        producer1.saleProduct(1000f);
    }
}
