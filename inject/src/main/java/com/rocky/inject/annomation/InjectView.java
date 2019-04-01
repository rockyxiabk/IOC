package com.rocky.inject.annomation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description : com.rocky.inject.annomation
 *
 * @author : rocky
 * @Create Time : 2019/3/30 1:48 PM
 * @Modified Time : 2019/3/30 1:48 PM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectView {
    int value();
}
