package com.lxy.study2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class JavaLearnActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_learn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d("ttt1","线程ID：" + Thread.currentThread().getId() );

        Button MyThreadButton = (Button) findViewById(R.id.create_thread);
        MyThreadButton.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void  onClick(View v) {
        switch (v.getId()){
            case R.id.create_thread:
                Toast.makeText(this, "创建线程了", Toast.LENGTH_SHORT).show();
                Thread MyThread1 = new Thread(){
                    public void run() {
                        Log.d("ttt2","线程ID：" + Thread.currentThread().getId() );
                    }
                };
                Thread MyThread2 = new Thread(){
                    public void run() {
                        Log.d("ttt3","线程ID：" + Thread.currentThread().getId() );
                    }
                };
                //真正创建子线程
                MyThread1.start();
                //没有创建子线程，沿用主线程
                MyThread2.run();
                break;
            default:
                break;
        }
    }

}
