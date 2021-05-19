package com.lga.proxy.jdk;

import java.lang.reflect.Proxy;

public class JDKProxyFactory {


    public static Object getProxyObject(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new DebugInvocationHandler(target));
    }
}
