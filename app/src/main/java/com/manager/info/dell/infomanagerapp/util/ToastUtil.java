package com.manager.info.dell.infomanagerapp.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Description
 * <p>
 * Created by Liu Huanbin
 * 2017/6/23
 */

public class ToastUtil {
    private static Toast mToast;

    public static void showToast(Context context, String info) {
        if (info == null) {
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(App.getContext(), info, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(info);
        }
//        LogUtil.i("app info", info);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }

    public static void showToast(Context context, int stringId) {
        showToast(context, context.getResources().getString(stringId));
    }

    public static void showToast(String msg) {
        showToast(App.getContext(), msg);
    }

    public static void showToast(int msgId) {
        showToast(App.getContext(), App.getContext().getString(msgId));
    }
}
