package com.lxy.study2;

/**
 * Created by wy on 2015/9/21.
 */
public class CustomListView {
    private String a,b;

    public CustomListView(String name, String detail){
        this.a = name;
        this.b = detail;
    }

    public String getName(){
        if(this.a.isEmpty())
            return "fail";
        return this.a;
    }

    public String getDetail(){
        if (this.b.isEmpty())
            return "fail";
        return this.b;
    }
}
