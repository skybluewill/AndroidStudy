package com.lxy.study2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //Toast.makeText(context, "收到广播啦", Toast.LENGTH_LONG).show();
        ActivityCollector.finishAll();
        Intent intent1 = new Intent(context, MainActivity.class);
        intent1 = intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
        //throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context, "收到广播啦", Toast.LENGTH_LONG).show();
    }
}
