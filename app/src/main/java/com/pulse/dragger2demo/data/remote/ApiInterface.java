package com.pulse.dragger2demo.data.remote;

/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by nikhil.vadoliya on 25-09-2017.
 */


public interface ApiInterface {


    @GET("login")
    Call<String> userLogin(@Url String loginRequest);

    @GET("signup")
    Call<String> userSignIn(@Url String signInRequest);


}
