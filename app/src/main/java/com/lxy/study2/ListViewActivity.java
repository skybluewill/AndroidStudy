package com.lxy.study2;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    //private String[] data = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    private List<CustomListView> data = new ArrayList<CustomListView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initData();
        //ArrayAdapter adapter = new ArrayAdapter(ListViewActivity.this,android.R.layout.simple_list_item_1,data);
        CustomAdapter adapter = new CustomAdapter(ListViewActivity.this,R.layout.custom_list_view,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private  void  initData(){
        CustomListView flower = new CustomListView("花","红色的花");
        CustomListView apple = new CustomListView("苹果","红色的苹果");
        CustomListView shui = new CustomListView("水","蓝蓝的水");
        this.data.add(flower);
        data.add(apple);
        data.add(shui);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
