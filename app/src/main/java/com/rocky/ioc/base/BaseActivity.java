package com.rocky.ioc.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rocky.inject.InjectManager;

/**
 * Description : com.rocky.ioc
 *
 * @author : rocky
 * @Create Time : 2019/3/30 1:29 PM
 * @Modified Time : 2019/3/30 1:29 PM
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectManager.inject(this);
    }
}
