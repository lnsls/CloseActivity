package com.lns.closeactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 *    /\_/\
 *  =( °w° )=
 *    )   (  //
 *   (__ __)//
 *
 * Created by lns on 2017/5/25.
 */
public class ActivityC extends AppCompatActivity {

    private static final String TAG = "ActivityC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        // 将 Activity 添加到 MyApplication Activity List
        MyApplication.getInstance().addActivity(this);

    }

    public void onCloseC(View view) {

        // 关闭当前 Activity
        finish();

    }

    public void onCloseA(View view) {

        // 关闭 Activity A
        ActivityA.instance.finish();

    }

    public void onCloseAll(View view) {

        // 关闭 MyApplication list 中的所有 Atyivity
        MyApplication.getInstance().exit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy: ActivityC");
        Toast.makeText(this, "Activity C 关闭了", Toast.LENGTH_SHORT).show();

    }

}
