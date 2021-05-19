package com.lga.proxy;

import com.lga.proxy.cglib.AliSmsService;
import com.lga.proxy.cglib.CglibProxyFactory;
import com.lga.proxy.jdk.JDKProxyFactory;
import com.lga.proxy.jdk.UserService;
import com.lga.proxy.jdk.UserServiceImpl;



public class ProxyTestMain {

    public static void main(String[] args) {

//        testJdkProxy();

        testCglibProxy();
    }




    /**
     * jdk 动态代理有个致命的问题就是只能代理实现了接口的类
     * 为了解决这个问题，可以使用CGLIB 动态代理机制避免
     */
    public static void testJdkProxy() {
        ((UserService) JDKProxyFactory.getProxyObject(new UserServiceImpl())).login();
    }


    public static void testCglibProxy() {
        ((AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class)).send("haha");
    }
}
