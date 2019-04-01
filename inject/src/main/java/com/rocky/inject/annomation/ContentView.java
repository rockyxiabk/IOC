package com.rocky.inject.annomation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description : com.rocky.inject.annomation
 *
 * @author : rocky
 * @Create Time : 2019/3/30 1:35 PM
 * @Modified Time : 2019/3/30 1:35 PM
 */
@Target(ElementType.TYPE)//注解作用在 类型？ 之上 （type：类）
@Retention(RetentionPolicy.RUNTIME) //预编译
public @interface ContentView {
    int value();//返回类型
}
