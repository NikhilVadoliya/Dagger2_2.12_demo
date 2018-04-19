package com.pulse.dragger2demo.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pulse.dragger2demo.R;
import com.pulse.dragger2demo.base.BaseActivity;
import com.pulse.dragger2demo.data.DataManager;
import com.pulse.dragger2demo.fragment.UserDetailFragment;

import javax.inject.Inject;

public class DetailActivity extends BaseActivity {

    @Inject
    DataManager dataManager;

    android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_detail);

        fragmentManager = getSupportFragmentManager();
        Toast.makeText(this, "Actvity-" + dataManager.getAccessToken(), Toast.LENGTH_SHORT).show();
        findViewById(R.id.btn_set_frag).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentManager.getFragments().size() == 0)
                    fragmentManager.beginTransaction().add(R.id.fragment_container, new UserDetailFragment()).commit();
            }
        });
    }
}
