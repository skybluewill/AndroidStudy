package com.lxy.study2;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class SensorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        TextView textView = new TextView(this);

        StringBuffer status = new StringBuffer();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : sensors) {
            status.append(sensor.getName()+"___");
            status.append(sensor.getPower()+"mA_");
            status.append(sensor.getMaximumRange()+"___");
            status.append(sensor.getType()+"___");
            status.append(sensor.getVendor()+"___");
            status.append(sensor.getVersion()+"\n\n");
        }
        textView.setText(status.toString());
        linearLayout.addView(textView);
        setContentView(linearLayout);
    }
}
