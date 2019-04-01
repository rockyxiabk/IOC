package com.rocky.inject.annomation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description : com.rocky.inject.annomation
 *
 * @author : rocky
 * @Create Time : 2019/3/30 2:02 PM
 * @Modified Time : 2019/3/30 2:02 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@EventBase(listenerSetter = "setOnClickListener", listenerType = View.OnClickListener.class,callBackListener = "onClick")
public @interface OnClick {
    int[] value();
}
