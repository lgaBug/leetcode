package com.lga.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DebugInvocationHandler implements InvocationHandler {

    private Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行之前");
        Object result = method.invoke(target, args);
        System.out.println("执行之后");
        return result;
    }


    public static void main(String[] args) {

        UserService userService = (UserService) JDKProxyFactory.getProxyObject(new UserServiceImpl());
        userService.login();
    }
}
