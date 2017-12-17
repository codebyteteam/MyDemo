package com.mydemo.common;


import android.content.Context;
import android.content.SharedPreferences;

public class SharePref {
    private SharedPreferences pref;
    public SharePref(Context mContext){
         pref = mContext.getSharedPreferences("MyPref", 0); // 0 - for private mode
    }
    public void setUserIdToPref(String userId){
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("userId",userId);
        editor.apply();
    }
    public String getUserIdFromPref(){
        return pref.getString("userId","");
    }

}
