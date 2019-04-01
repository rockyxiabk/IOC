package com.rocky.ioc;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rocky.inject.annomation.ContentView;
import com.rocky.inject.annomation.InjectView;
import com.rocky.inject.annomation.OnClick;
import com.rocky.inject.annomation.OnLongClick;
import com.rocky.ioc.base.BaseActivity;
import com.rocky.ioc.builder.User;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @InjectView(R.id.button)
    Button btn;
    @InjectView(R.id.textView)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, btn.getText().toString(), Toast.LENGTH_SHORT).show();

        //builder
        User user = new User.UserBuilder("11", "rocky").setBirthday(SystemClock.currentThreadTimeMillis())
                .setDes("i am rocky")
                .setTime(SystemClock.currentThreadTimeMillis())
                .builder();
        Log.d("tag", user.toString());
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    @OnClick({R.id.button, R.id.textView})
    public void hbkljh(View view) {
        switch (view.getId()) {
            case R.id.button:
                Toast.makeText(this, "click button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textView:
                Toast.makeText(this, "click tectview", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @OnLongClick({R.id.button, R.id.textView})
    public void kjbi(View view) {
        switch (view.getId()) {
            case R.id.button:
                Toast.makeText(this, "long click button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textView:
                Toast.makeText(this, "long click tectview", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
