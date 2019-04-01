package com.rocky.inject;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.rocky.inject.annomation.ContentView;
import com.rocky.inject.annomation.EventBase;
import com.rocky.inject.annomation.InjectView;
import com.rocky.inject.annomation.ListenerInvocationHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description : com.rocky.inject
 *
 * @author : rocky
 * @Create Time : 2019/3/30 1:32 PM
 * @Modified Time : 2019/3/30 1:32 PM
 */
public class InjectManager {

    public static void inject(Activity activity) {
        injectLayout(activity);

        injectView(activity);

        injectEvent(activity);
    }

    private static void injectLayout(Activity activity) {
        Class<? extends Activity> activityClass = activity.getClass();
        ContentView contentView = activityClass.getAnnotation(ContentView.class);
        if (null != contentView) {
            int value = contentView.value();
            try {
                Method method = activityClass.getMethod("setContentView", int.class);
                method.invoke(activity, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void injectEvent(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annotationType = annotation.annotationType();
                if (null!=annotationType){
                    EventBase eventBase = annotationType.getAnnotation(EventBase.class);
                    String listenerSetter = eventBase.listenerSetter();
                    Class<?> listenerType = eventBase.listenerType();
                    String callBackListener = eventBase.callBackListener();
                    try {

                        Method method1 = annotationType.getDeclaredMethod("value");
                        int[] invokes = (int[]) method1.invoke(annotation);

                        ListenerInvocationHandler handler = new ListenerInvocationHandler(activity);
                        handler.addMethod(callBackListener,method);

                        Object listener = Proxy.newProxyInstance(listenerType.getClassLoader(), new Class[]{listenerType}, handler);

                        for (int viewId : invokes) {
                            View viewById = activity.findViewById(viewId);
                            Method setter = viewById.getClass().getMethod(listenerSetter, listenerType);
                            setter.invoke(viewById,listener);
                        }
                    } catch (Exception e) {
                        Log.e("tag",e.toString());
                    }
                }
            }
        }

    }

    private static void injectView(Activity activity) {
        Class<? extends Activity> activityClass = activity.getClass();
        Field[] fields = activityClass.getDeclaredFields();
        for (Field field : fields) {
            InjectView injectView = field.getAnnotation(InjectView.class);
            if (null != injectView) {
                int value = injectView.value();
                try {
                    Method method = activityClass.getMethod("findViewById", int.class);//私有方法
                    Object invoke = method.invoke(activity, value);
                    field.setAccessible(true);//设置该属性为可获得
                    field.set(activity, invoke);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
