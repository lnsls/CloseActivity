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
public class ActivityB extends AppCompatActivity {

    private static final String TAG = "ActivityB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        // 将 Activity 添加到 MyApplication Activity List
        MyApplication.getInstance().addActivity(this);

    }

    public void onClickB(View view) {

        Intent i = new Intent(ActivityB.this, ActivityC.class);
        startActivity(i);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy: ActivityB");
        Toast.makeText(this, "Activity B 关闭了", Toast.LENGTH_SHORT).show();

    }

}
