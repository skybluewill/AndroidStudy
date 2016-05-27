package com.lxy.study2;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wy on 2016/4/7.
 */
public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    /*public static void finishAll(){
        if (!activities.isEmpty()){
            for (Activity activity : activities){
                if (!activity.isFinishing()){
                    activity.finish();
                    removeActivity(activity);
                    Log.d("ActivityCollector1", "囖囖被调用咯");
                }
            }
        }
        Log.d("ActivityCollector", "被调用咯");
    }*/
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        Log.d("ActivityList", activities.toString());
    }
}
