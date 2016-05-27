package com.lxy.study2;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by wy on 2015/9/21.
 */
public class SelfTitle extends LinearLayout implements View.OnClickListener {
    public SelfTitle(Context context, AttributeSet attrs){
        super(context, attrs);
        View inflate = LayoutInflater.from(context).inflate(R.layout.self_title, this); //
        Button back = (Button) findViewById(R.id.title_back);
        Button exit = (Button) findViewById(R.id.title_exit);
        back.setOnClickListener(this);
        exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.title_back:
                ((Activity) getContext()).finish();
                Log.d("title_back","窗口返回");
                break;
            case R.id.title_exit:
                //ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                //manager.restartPackage(getPackageName());
                ((Activity)getContext()).finish();
                System.exit(0);
                Log.d("title_exit","窗口退出");
                break;
            default:
                break;
        }
    }

}
