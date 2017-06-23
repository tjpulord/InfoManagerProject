package com.manager.info.dell.infomanagerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void jumpActivity(Class<? extends BasicActivity> act) {
        jumpActivity(act, null);
    }
    public void jumpActivity(Class<? extends BasicActivity> act, Bundle bundle) {
        Intent i = new Intent(this, act);
        if (bundle != null) {
            i.putExtras(bundle);
        }
        startActivity(i);
    }
}
