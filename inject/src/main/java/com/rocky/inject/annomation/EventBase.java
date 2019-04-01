package com.rocky.inject.annomation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description : com.rocky.inject.annomation
 *
 * @author : rocky
 * @Create Time : 2019/3/30 2:03 PM
 * @Modified Time : 2019/3/30 2:03 PM
 */
@Target(ElementType.ANNOTATION_TYPE)//元注解 注解在注解之上
@Retention(RetentionPolicy.RUNTIME)
public @interface EventBase {

    //事件的3个成员
    //1, setOnxxxListener();方法名
    String listenerSetter();

    //2，监听对象
    Class<?> listenerType();

    //3,回调方法
    String callBackListener();

}
