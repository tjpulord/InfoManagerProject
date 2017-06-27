package com.manager.info.dell.infomanagerapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

public class BasicActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题拦
    }

    public void jumpActivity(Context context, Class<? extends BasicActivity> act) {
        jumpActivity(context, act, null);
    }
    public void jumpActivity(Context context, Class<? extends BasicActivity> act, Bundle bundle) {
        Intent i = new Intent(context, act);
        if (bundle != null) {
            i.putExtras(bundle);
        }
        startActivity(i);
    }
}
