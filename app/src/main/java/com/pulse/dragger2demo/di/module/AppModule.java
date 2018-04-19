package com.pulse.dragger2demo.di.module;


/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.pulse.dragger2demo.data.DataManager;
import com.pulse.dragger2demo.data.local.AppPreferenceManager;
import com.pulse.dragger2demo.data.local.DbHelper;
import com.pulse.dragger2demo.data.remote.ApiInterface;
import com.pulse.dragger2demo.di.annotation.ApiBaseUrl;
import com.pulse.dragger2demo.di.annotation.ApiFullUrl;
import com.pulse.dragger2demo.di.annotation.ApiVersion;
import com.pulse.dragger2demo.di.annotation.DataBaseName;
import com.pulse.dragger2demo.helper.Constant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nikhil.vadoliya on 10-04-2018.
 */


@Module
public class AppModule {


    @Provides
    @Singleton
    Context provideApplicationContext(Application application) {
        return application;
    }


    //==============================================Retrofit Module========================================
    @Provides
    @ApiBaseUrl
    String provideBaseUrlString() {
        return Constant.ApiHelper.BASE_URL;
    }

    @Provides
    @ApiVersion
    String provideApiVersion() {
        return Constant.ApiHelper.API_VERSION;
    }

    @Provides
    @ApiFullUrl
    String provideFullUrlString(@ApiBaseUrl String baseUrl, @ApiVersion String apiVersion) {
        return baseUrl + apiVersion;
    }

    @Provides
    @Singleton
    public OkHttpClient getHttpClientBuilder() {

        // Setup Logging interceptor
        HttpLoggingInterceptor mLoggingInterceptor = new HttpLoggingInterceptor();
        mLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                return chain.proceed(builder.build());
            }
        };

        httpClient.addInterceptor(interceptor);
        httpClient.addInterceptor(mLoggingInterceptor);
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);

        return httpClient.build();
    }

    @Provides
    @Singleton
    Retrofit provideCall(@ApiFullUrl String fullUrl, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(fullUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public ApiInterface providesNetworkService(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

    //==============================================Retrofit Module========================================


    //==============================================SharaPreference Module========================================

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs(Context context) {
        return context.getSharedPreferences(Constant.Preference.SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    AppPreferenceManager appPreferenceManager(SharedPreferences sharedPreferences) {
        return new AppPreferenceManager(sharedPreferences);
    }
    //==============================================SharaPreference Module========================================


    //==============================================Database Module========================================

    @Provides
    @DataBaseName
    String provideDatabaseName() {
        return Constant.DB_NAME;
    }

    @Provides
    @Singleton
    Integer provideDatabaseVersion() {
        return Constant.DB_VERSION;
    }

    @Provides
    @Singleton
    DbHelper providerDataBase(Context context, @DataBaseName String databaseName, int version) {
        return new DbHelper(context, databaseName, version);
    }
    //==============================================Database Module========================================

     @Provides
     @Singleton
     DataManager providerDataManager(Context context, AppPreferenceManager sharedPreferences, DbHelper dbHelper,
                                     ApiInterface apiInterface) {
         return new DataManager(context, apiInterface, dbHelper, sharedPreferences);
     }


}
