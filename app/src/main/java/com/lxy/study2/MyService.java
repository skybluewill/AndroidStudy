package com.lxy.study2;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    String service = "MyService";
    String mac;
    public MyService() {
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d(service, "MyService is Created");
        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        mac = info.getMacAddress() == null ? "" : info.getMacAddress();
        Toast.makeText(this, mac,Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d(service, "on StartCommand is executed");
        return super.onStartCommand(intent, flags, startId);
    }

    //@Override
    public void onDestory(){
        super.onDestroy();
        Log.d(service, "MyService is Destory");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
