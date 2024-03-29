package org.commonstudy.others.proxys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: 铠甲勇士
 * @Description:
 * @Date: create in 2024/3/27 19:33
 */
public class ProxiedEntity implements IInterface {


    public String handler(int i) {
        System.out.println("执行ProxiedEntity的方法");
        return String.valueOf(i);
    }


    public static void main(String[] args) {
        ProxiedEntity proxiedEntity = new ProxiedEntity();
        IInterface o = (IInterface) Proxy.newProxyInstance(ProxiedEntity.class.getClassLoader(),
                ProxiedEntity.class.getInterfaces(), (proxy, method, args1) -> {
                    String name = method.getName();
                    System.out.println(name + " -->执行实际方法前");
                    Object result = method.invoke(proxiedEntity, args1);
                    System.out.println(name + " --> 执行实际方法后");
                    return result;
                });
        System.out.println(o.handler(3));
    }
}
