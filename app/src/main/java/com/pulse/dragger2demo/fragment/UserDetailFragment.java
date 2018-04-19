package com.pulse.dragger2demo.fragment;


/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pulse.dragger2demo.R;
import com.pulse.dragger2demo.base.BaseFragment;
import com.pulse.dragger2demo.data.DataManager;

import javax.inject.Inject;

/**
 * Created by nikhil.vadoliya on 19-04-2018.
 */


public class UserDetailFragment extends BaseFragment {


    View mView;

    @Inject
    DataManager dataManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_user_detail, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity(), "Fragment- " + dataManager.getAccessToken(), Toast.LENGTH_SHORT).show();
    }
}
