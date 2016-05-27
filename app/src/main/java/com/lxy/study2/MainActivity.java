package com.lxy.study2;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;
import android.os.Process;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_main);                 //为当前活动设置布局
        Button project1 = (Button) findViewById(R.id.button);   //绑定布局里的按钮到project1变量
        project1.setOnClickListener(this);                      //设置project1按钮的监听器，期待值为View.OnclickListener，(这个是视图被点击的事件处理器)

        Button project2 = (Button) findViewById(R.id.button2);
        project2.setOnClickListener(this);

        Button project3 = (Button) findViewById(R.id.button3);
        project3.setOnClickListener(this);

        Button project4 = (Button) findViewById(R.id.button4);
        project4.setOnClickListener(this);

        Button project5 = (Button) findViewById(R.id.button5);
        project5.setOnClickListener(this);

        Button project6 = (Button) findViewById(R.id.start_service);
        project6.setOnClickListener(this);

        Button project7 = (Button) findViewById(R.id.stop_service);
        project7.setOnClickListener(this);

        Button project8 = (Button) findViewById(R.id.save_data);
        project8.setOnClickListener(this);

        Button project9 = (Button) findViewById(R.id.qqui);
        project9.setOnClickListener(this);

        Button project10 = (Button) findViewById(R.id.java_learn);
        project10.setOnClickListener(this);

        Button project11 = (Button) findViewById(R.id.system_inf);
        project11.setOnClickListener(this);

        Button project12 = (Button) findViewById(R.id.sensor_inf);
        project12.setOnClickListener(this);

        //int pid = Process.myPid();
       // Toast.makeText(this, pid, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v){                                //按View.OnClickListener的接口要求重写onClick方法。
        switch (v.getId()){
            case R.id.button:
                Intent intent1 = new Intent(MainActivity.this,Project1Activity.class);  //参数1 -->包的上下文环境（packageContext）,参数2 --> Class<?> cls（形式为“activity名.class”,暂不能译）
                startActivity(intent1);                                                 //归属于android.content.context
                break;
            case R.id.button2:
                Intent intentSpec = new Intent(Intent.ACTION_DIAL);
                intentSpec.setData(Uri.parse("tel://10086.com"));
                startActivity(intentSpec);
                Log.d("First Logcat","to first use logcat tools");
                break;
            case R.id.button3:
                Intent intentReturnData = new Intent(MainActivity.this,ReturnDataActivity.class);
                startActivityForResult(intentReturnData,200);
                Log.d("aaa","click button3");
                break;
            case R.id.button4:
                Intent intentSelfTitle = new Intent(MainActivity.this,SelfTitleActivity.class);
                startActivity(intentSelfTitle);
                break;
            case R.id.button5:
                Intent intentListView = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intentListView);
                break;
            case R.id.start_service:
                Intent startIntent = new Intent(MainActivity.this, MyService.class);
                startService(startIntent);
                break;
            case R.id.stop_service:
                Intent stopIntent = new Intent(MainActivity.this, MyService.class);
                stopService(stopIntent);
                break;
            case R.id.save_data:
                Intent saveIntent = new Intent(MainActivity.this, SaveDataActivity.class);
                startActivity(saveIntent);
                break;
            case R.id.qqui:
                Intent qquiIntent = new Intent(MainActivity.this, QQUIActivity.class);
                startActivity(qquiIntent);
                break;
            case R.id.java_learn:
                Intent JavaIntent = new Intent(MainActivity.this, JavaLearnActivity.class);
                startActivity(JavaIntent);
                break;
            case R.id.system_inf:
                Intent SystemIntent = new Intent(MainActivity.this, GetSystemInfDialog.class);
                startActivity(SystemIntent);
                break;
            case R.id.sensor_inf:
                Intent sensorIntent = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(sensorIntent);
                break;

            default:
                break;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        switch (requestCode){
            case 200:
                if(resultCode == RESULT_OK){
                    String data = intent.getStringExtra("result");
                    Toast toast = Toast.makeText(this, data, Toast.LENGTH_SHORT);
                    toast.show();
                    Log.d("ddd",data);

                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {                                                 //目前尚未深入探索，创建菜单，未确定
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {                                           //目前尚未深入探索，创建菜单，未确定
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
