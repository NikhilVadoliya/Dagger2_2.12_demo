package com.pulse.dragger2demo.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.pulse.dragger2demo.di.annotation.PreferenceInfo;

import javax.inject.Inject;

/**
 * Created by alpesh.rathod on 2/9/2018.
 */

public class AppPreferenceManager {

    //public static final String PREF_NAME = "com.pulse.brag.PREF_NAME";

    private static final String IS_LOGIN = "isLogin";
    private static final String DEVICE_TYPE = "deviceType";
    private static final String OS_VERSION = "osVersion";
    private static final String ACCESS_TOKEN = "accessToken";
    private static final String DEVICE_TOKEN = "deviceToken";
    private static final String NOTIFICATION_ID = "notificationid";
    private static final String USER_DATA = "userdata";

    private final SharedPreferences mPref;

    @Inject
    public AppPreferenceManager(SharedPreferences sharedPreferences) {
        mPref = sharedPreferences;
    }

    public void put(String key, String value) {
        mPref.edit().putString(key, value).apply();
    }

    public void put(String key, int value) {
        mPref.edit().putInt(key, value).apply();
    }

    public void put(String key, float value) {
        mPref.edit().putFloat(key, value).apply();
    }

    public void put(String key, boolean value) {
        mPref.edit().putBoolean(key, value).apply();
    }

    public String get(String key, String defaultValue) {
        return mPref.getString(key, defaultValue);
    }

    public Integer get(String key, int defaultValue) {
        return mPref.getInt(key, defaultValue);
    }

    public Float get(String key, float defaultValue) {
        return mPref.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue) {
        return mPref.getBoolean(key, defaultValue);
    }

    public void deleteSavedData(String key) {
        mPref.edit().remove(key).apply();
    }

}
