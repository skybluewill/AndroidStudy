package com.lxy.study2;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * Created by wy on 2016/5/18.
 */
public class GetSystemInfDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.get_system_inf_dialog);
        //LinearLayout linearLayout = new LinearLayout(this);
        //setContentView(linearLayout);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.get_system_inf_dialog);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.wrap_line1);


        TextView textView = new TextView(this);

        StringBuffer status = new StringBuffer();

        //获取配置信息并添加到StringBuffer
        Configuration cfg = getResources().getConfiguration();
        status.append("densityDpi(int|DPI?):" + cfg.densityDpi + "手机的DPI？" + "\n");
        status.append("fontScale:" + cfg.fontScale + "字体比例" + "\n");
        status.append("hardKeyboardHidden:" + cfg.hardKeyboardHidden + "表明硬件键盘是否存在隐藏" + "\n");
        status.append("keyboard:" + cfg.keyboard + "？" + "\n");
        status.append("keyboardHidden:" + cfg.keyboardHidden + "键盘是否可用" + "\n");
        status.append("locale:" + cfg.locale + "当前用户优先选定区域，和选定的区域资源一致" + "\n");
        status.append("mcc:" + cfg.mcc + "手机国际码，和选定的手机国际码资源保持一致" + "\n");
        status.append("mnc:" + cfg.mnc + "手机网络码，和选定的手机网络码资源保持一致" + "\n");
        status.append("navigation:" + cfg.navigation + "导航是否可用" + "\n");
        status.append("navigationHidden:" + cfg.navigationHidden + "？" + "\n");
        status.append("orientation:" + cfg.orientation + "屏幕方向" + "\n");
        status.append("screenHeightDp:" + cfg.screenHeightDp + "\n");
        status.append("screenWidthDp:" + cfg.screenWidthDp + "\n");
        status.append("screenLayout:" + cfg.screenLayout + "\n");
        status.append("smallestScreenWidthDp:" + cfg.densityDpi + "\n");
        status.append("touchscreen:" + cfg.densityDpi + "\n");
        status.append("uiMode:" + cfg.densityDpi + "\n");
        status.append("产品名称:" + Build.PRODUCT + "\n");
        status.append("CPU型号:" + Build.CPU_ABI + "\n");
        status.append("标签:" + Build.TAGS + "\n");
        status.append("手机型号:" + Build.MODEL + "\n");
        status.append("SDK版本:" + Build.VERSION.SDK + "\n");
        status.append("系统版本:" + Build.VERSION.RELEASE + "\n");
        status.append("用户组:" + Build.USER + "\n");
        status.append("显示:" + Build.DISPLAY + "\n");
        status.append("品牌:" + Build.BRAND + "\n");
        status.append("无线电固件版本:" + Build.getRadioVersion() + "\n");
        status.append("硬件名称:" + Build.HARDWARE + "\n");
        status.append("TIME:" + new SimpleDateFormat("yyyy-MM-DD").format(Build.TIME) + "\n");
        status.append("屏幕分辨率:" + getScreenPixel().get("width") + "x" + getScreenPixel().get("height") + "\n");
        status.append("手机位置:" + telephonyManager.getCellLocation() + "\n");
        status.append("网络商名称 NetworkOperatorName:" + telephonyManager.getNetworkOperatorName() + "\n");
        status.append("返回国际长途区号 NetworkCountryIso:" + telephonyManager.getNetworkCountryIso() + "\n");
        status.append("mccmnc NetworkOperator:" + telephonyManager.getNetworkOperator() + "\n");
        status.append("网络类型 NetworkType:" + telephonyManager.getNetworkType() + "\n");
        status.append("根据NetworkType获取相应网络号:" + getNetworkTypeName(telephonyManager) + "\n");
        status.append("电话状态[0 无活动/1 响铃/2 摘机]CallState:" + telephonyManager.getCallState() + "\n");
        status.append("唯一的设备ID DeviceId:" + telephonyManager.getDeviceId() + "\n");
        status.append("设备的软件版本号:" + telephonyManager.getDeviceSoftwareVersion() + "\n");
        status.append("手机号:" + telephonyManager.getLine1Number() + "\n");
        status.append("手机类型:" + telephonyManager.getPhoneType() + "\n");
        status.append("获取ISO国家码，相当于提供SIM卡的国家码:" + telephonyManager.getSimCountryIso() + "\n");
        status.append("获取SIM卡提供的移动国家码和移动网络码.5或6位的十进制数字" +
                "SIM卡的状态必须是 SIM_STATE_READY(使用getSimState()判断):" + telephonyManager.getSimOperator() + "\n");
        status.append("服务商名称:" + telephonyManager.getSimOperatorName() + "\n");
        status.append("SIM卡的序列号:" + telephonyManager.getSimSerialNumber() + "\n");
        /*
        * SIM的状态信息：
        *  SIM_STATE_UNKNOWN          未知状态 0
        SIM_STATE_ABSENT           没插卡 1
        SIM_STATE_PIN_REQUIRED     锁定状态，需要用户的PIN码解锁 2
        SIM_STATE_PUK_REQUIRED     锁定状态，需要用户的PUK码解锁 3
        SIM_STATE_NETWORK_LOCKED   锁定状态，需要网络的PIN码解锁 4
        SIM_STATE_READY            就绪状态 5
        */
        status.append("SIM的状态信息:" + telephonyManager.getSimState() + "\n");
        /*
        * 唯一的用户ID：
        * 例如：IMSI(国际移动用户识别码) for a GSM phone.
        * 需要权限：READ_PHONE_STATE
        */
        status.append("用户ID（IMSI）:" + telephonyManager.getSubscriberId() + "\n");
        status.append("取得和语音邮件相关的标签，即为识别符 :" + telephonyManager.getVoiceMailAlphaTag() + "\n");
        status.append("获取语音邮件号码:" + telephonyManager.getVoiceMailNumber() + "\n");
        status.append("是否漫游 isNetworkRoaming:" + telephonyManager.isNetworkRoaming() + "\n");
        status.append("ICC卡是否存在:" + telephonyManager.hasIccCard() + "\n");
        status.append("附近基站信息:" + telephonyManager.getNeighboringCellInfo() + "\n");
        status.append("手机号:" + telephonyManager.getLine1Number() + "\n");

        //添加到TextView
        textView.setText(status.toString());
        linearLayout.addView(textView);
        //getMemoryInfo();
        //创建右键菜单
        setViews();
        //获取可利用内存
        getAvailMemory(this);
    }

    public void  getMemoryInfo() {
        String str1 = "/proc/meminfo";
        String str2 = "";

        try {
            FileReader fr = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(fr,8192);
            while ((str2 = localBufferedReader.readLine()) != null) {
                Log.d("TAG", "---" + str2);
            }
        } catch ( IOException e) {

        }
    }

    //获取可利用内存
    public  long getAvailMemory(Context context){
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(mi);
        return mi.availMem;
    }

    //获取屏幕分辨率
    public Map getScreenPixel(){
        Map attr = new HashMap();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        attr.put("width", size.x );
        attr.put("height", size.y);
        return  attr;
    }

    //注册（点击该节点） 右键菜单
    private void setViews() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.wrap_line1);
        registerForContextMenu(linearLayout);
    }

    //复写创建菜单方法
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_right, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //复写右键菜单响应方法
    @Override
    public boolean onContextItemSelected(MenuItem item) {
       switch (item.getItemId()) {
           case R.id.right1:
               LinearLayout linearLayout = (LinearLayout) findViewById(R.id.wrap_line1);
               linearLayout.setBackgroundColor(R.color.black);
       }

        return true;
    }


    public String getNetworkTypeName(TelephonyManager telephonyManager) {
        int networkType = telephonyManager.getNetworkType();
        switch (networkType) {
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                return "UNKNOWN";
            case TelephonyManager.NETWORK_TYPE_GPRS:
                return "GPRS";
            case TelephonyManager.NETWORK_TYPE_EDGE:
                return "EDGE";
            case  TelephonyManager.NETWORK_TYPE_UMTS:
                return "UMTS";
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                return "HSDPA";
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                return "HSUPA";
            case TelephonyManager.NETWORK_TYPE_HSPA:
                return "HSPA";
            case TelephonyManager.NETWORK_TYPE_CDMA:
                return "CDMA";
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                return "EVDO_0";
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                return "EVDO_A";
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                return "EVDO_B";
            case TelephonyManager.NETWORK_TYPE_1xRTT:
                return "1xRTT";
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return "IDEN";
            case TelephonyManager.NETWORK_TYPE_LTE:
                return "LTE";
            case TelephonyManager.NETWORK_TYPE_EHRPD:
                return "EHRPD";
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return "HSPAP";
            default:
                return "UNKNOWN";
        }
    }


}
