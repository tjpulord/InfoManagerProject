package com.manager.info.dell.infomanagerapp.util;

import android.view.View;

import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import rx.functions.Action1;

/**
 * Description
 * <p>
 * Created by Liu Huanbin
 * 2017/6/23
 */

public class InjectUtils {
    public static void clicks(View v, Action1<Void> action) {
        RxView.clicks(v).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(action);
    }
}
