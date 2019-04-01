package com.rocky.inject.annomation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Description : com.rocky.inject.annomation
 *
 * @author : rocky
 * @Create Time : 2019/3/30 2:26 PM
 * @Modified Time : 2019/3/30 2:26 PM
 */
public class ListenerInvocationHandler implements InvocationHandler {
    //要拦截activity中的某些方法
    private Object target;
    private HashMap<String, Method> methodHashMap = new HashMap<>();

    public ListenerInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if (null!=target){
            String name = method.getName();
            method = methodHashMap.get(name);
            if (null!=method){
               return method.invoke(target,objects);
            }
        }
        return null;
    }

    /**
     * 添加要拦截的方法
     *
     * @param name
     * @param method
     */
    public void addMethod(String name, Method method) {
        methodHashMap.put(name, method);
    }
}
