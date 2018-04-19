package com.pulse.dragger2demo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pulse.dragger2demo.R;
import com.pulse.dragger2demo.base.BaseActivity;
import com.pulse.dragger2demo.data.DataManager;
import com.pulse.dragger2demo.data.local.DbHelper;
import com.pulse.dragger2demo.di.annotation.DataBaseName;

import javax.inject.Inject;


public class MainActivity extends BaseActivity {


    @Inject
    @DataBaseName
    String name;

    @Inject
    DbHelper dbHelper;

    @Inject
    DataManager dataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);
//        setContentView(R.layout.activity_main);

        Toast.makeText(this, "" + dataManager.getUser(1), Toast.LENGTH_SHORT).show();

        dataManager.saveAccessToken("123123ASDZXQAS");
        findViewById(R.id.btn_next_activty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DetailActivity.class));
            }
        });
    }
}
