package com.pulse.dragger2demo.di.builder;


/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

import com.pulse.dragger2demo.activities.DetailActivity;
import com.pulse.dragger2demo.activities.MainActivity;
import com.pulse.dragger2demo.fragment.UserDetailFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by nikhil.vadoliya on 10-04-2018.
 */


@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract DetailActivity contributeDetailActivity();

    @ContributesAndroidInjector
    abstract UserDetailFragment contributeUserDetailFragment();
}
