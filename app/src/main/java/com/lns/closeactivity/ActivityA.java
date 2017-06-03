package com.lns.closeactivity;

import android.content.Intent;
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
public class ActivityA extends AppCompatActivity {

    private static final String TAG = "ActivityA";

    // 静态变量instance,初始化为this
    public static ActivityA instance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        // 将 Activity 添加到 MyApplication Activity List
        //MyApplication.getInstance().addActivity(this);

        // 静态变量instance,初始化为this
        instance = this;

    }

    public void onClickA(View view) {

        Intent i = new Intent(ActivityA.this, ActivityB.class);
        startActivity(i);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy: ActivityA");
        Toast.makeText(this, "Activity A 关闭了", Toast.LENGTH_SHORT).show();

    }

}
