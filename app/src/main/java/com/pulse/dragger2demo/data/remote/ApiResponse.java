package com.pulse.dragger2demo.data.remote;


import android.util.Log;

import com.google.gson.JsonSyntaxException;
import com.pulse.dragger2demo.helper.Constant;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by alpesh.rathod on 2/6/2018.
 */

public abstract class ApiResponse<T> implements Callback<T> {

    public abstract void onSuccess(T t, Headers headers);

    public abstract void onError(ApiError t);

    public void checkData(T t, Headers headers) {
        if (t != null) {
            onSuccess(t, headers);
        } else {
            onError(new ApiError(Constant.IErrorCode.defaultErrorCode, Constant.IErrorMessage.IO_EXCEPTION));
        }
    }


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            checkData(response.body(), response.headers());
        } else {
            onError(new ApiError(Constant.IErrorCode.defaultErrorCode, Constant.IErrorMessage.IO_EXCEPTION));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable th) {
        String val = "";
        if (!(call == null || call.request() == null || call.request().body() == null))
            val = call.request().body().toString();


        if (th instanceof JsonSyntaxException) {
            Log.i("JsonSyntaxException", "onFailure: onJsonParsing error" + th.getMessage());
        }

        if (th instanceof UnknownHostException) {
            onError(new ApiError(Constant.IErrorCode.notInternetConnErrorCode, Constant.IErrorMessage.NO_INTERNET_CONNECTION));
        } else if (th instanceof SocketTimeoutException) {
            onError(new ApiError(Constant.IErrorCode.socketTimeOutError, Constant.IErrorMessage.TIME_OUT_CONNECTION));
        } else {
            onError(new ApiError(Constant.IErrorCode.ioExceptionOtherErrorCode, Constant.IErrorMessage.IO_EXCEPTION_OTHER_ERROR));
        }
    }
}
