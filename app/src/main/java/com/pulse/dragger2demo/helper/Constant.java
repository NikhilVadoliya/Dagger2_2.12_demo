package com.pulse.dragger2demo.helper;


/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

import android.support.v4.BuildConfig;

/**
 * Created by nikhil.vadoliya on 10-04-2018.
 */


public class Constant {


    public static final String DB_NAME = "db_name";
    public static final int DB_VERSION = 1;

    public interface ApiHelper {
        String BASE_URL = "http://27.54.166.146:8090/BRAGWeb/api/";//demo
//        String BASE_URL = "http://192.168.131.10:8091/BRAGWeb/api/"; //local
        //String BASE_URL = "http://192.168.131.125:8085/BRAGWeb/api/"; //tushar

        String API_VERSION = "v1/";
        String APP_VERSION = BuildConfig.VERSION_NAME;
        String FULL_URL = BASE_URL + API_VERSION;

        String OS = "Android";

        String MAP_KEY_ACCESS_TOKEN = "access-token";
        String MAP_KEY_DEVICE_TOKEN = "device-token";
        String MAP_KEY_DEVICE_TYPE = "device-type";
        String MAP_APP_VERSION = "app-version";
        String MAP_KEY_OSV = "os-version";
        String MAP_KEY_OS = "os";
        String MAP_KEY_CART_NUM = "itemnoofcart";
        String MAP_KEY_NOTIFICATION_NUM = "unreadcount";
    }

    public interface IErrorCode {
        int defaultErrorCode = 5001;
        int notInternetConnErrorCode = 5002;
        int ioExceptionCancelApiErrorCode = 5003;
        int ioExceptionOtherErrorCode = 5004;
        int socketTimeOutError = 5006;
    }

    public interface IErrorMessage {
        String CONTENT_NOT_MODIFIED = "Content not modified";
        String OTHER_EXCEPTION = "We could not complete your request";
        String SOMETHING_WRONG_ERROR = "Something went wrong!!\nPlease try again later.";

        String IO_EXCEPTION = "Something went wrong!!\nPlease try again later.";
        String NO_INTERNET_CONNECTION = "No internet connection.";
        String IO_EXCEPTION_CANCEL_API = "Something went wrong!!\nPlease try again later.";
        String IO_EXCEPTION_OTHER_ERROR = "Something went wrong!!\nPlease try again later.";
        String TIME_OUT_CONNECTION = "Connection timeout.\nPlease try again later.";
    }

    public interface Preference {
        String SHARE_PREFERENCE_NAME = "app_name";

        String DEVICE_TYPE = "deviceType";
    }
}
