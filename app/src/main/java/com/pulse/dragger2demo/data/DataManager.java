package com.pulse.dragger2demo.data;


/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

import android.content.Context;
import android.content.SharedPreferences;

import com.pulse.dragger2demo.data.local.AppPreferenceManager;
import com.pulse.dragger2demo.data.local.DbHelper;
import com.pulse.dragger2demo.data.remote.ApiInterface;
import com.pulse.dragger2demo.helper.Constant;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by nikhil.vadoliya on 10-04-2018.
 */

@Singleton
public class DataManager {

    private Context mContext;
    private ApiInterface mApiInterface;
    private AppPreferenceManager mSharedPreferences;
    private DbHelper mDbHelper;


    /**
     *
     * @param context  @link com.pulse.dagger2demo.di.module  -provideApplicationContext
     * @param apiInterface
     * @param dbHelper
     * @param sharedPrefsHelper
     */
    @Inject
    public DataManager(Context context,
                       ApiInterface apiInterface,
                       DbHelper dbHelper,
                       AppPreferenceManager sharedPrefsHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mSharedPreferences = sharedPrefsHelper;
        mApiInterface = apiInterface;
    }


    public void saveAccessToken(String accessToken) {
        mSharedPreferences.put(Constant.Preference.DEVICE_TYPE, accessToken);
    }

    public String getAccessToken() {
        return mSharedPreferences.get(Constant.Preference.DEVICE_TYPE, null);
    }

    public boolean createUser(String userid) {
        return mDbHelper.insertUser(userid);
    }

    public String getUser(int userId) {
        return mDbHelper.getUser(userId);
    }

    public Call<String> getUserDataApi(String url) {
        return mApiInterface.userLogin(url);
    }
}
