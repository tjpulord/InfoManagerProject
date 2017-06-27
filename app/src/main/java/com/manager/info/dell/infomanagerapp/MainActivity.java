package com.manager.info.dell.infomanagerapp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.manager.info.dell.infomanagerapp.databinding.ActivityMainBinding;
import com.manager.info.dell.infomanagerapp.util.ConstantUtil;
import com.manager.info.dell.infomanagerapp.util.ToastUtil;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class MainActivity extends BasicActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    private final int CAPTURE_ACTIVITY_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initView();
        ZXingLibrary.initDisplayOpinion(this);
    }

    private void initView() {
        binding.ivRecordInfo.setOnClickListener(this);
        binding.ivSearchInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_record_info:
                jumpActivity(getApplicationContext(), CreateInfoActivity.class);
                break;
            case R.id.iv_search_info:
                Intent intent = new Intent(this, MyScanUIActivity.class);
                startActivityForResult(intent, CAPTURE_ACTIVITY_RESULT);
//                Intent intent = new Intent(this, CaptureActivity.class);
//                startActivityForResult(intent, CAPTURE_ACTIVITY_RESULT);
                break;
            default:
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_ACTIVITY_RESULT) {
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String res = bundle.getString(CodeUtils.RESULT_STRING);
                    ToastUtil.showToast("解析结果：" + res);
                    Bundle b = new Bundle();
                    int pos = res.lastIndexOf("sn=");
                    if (pos > 0) {
                        b.putString(ConstantUtil.INFO_SN, res.substring(pos + 3));
                        jumpActivity(getApplicationContext(), InfoDetailActivity.class, b);
                    } else {
                        ToastUtil.showToast("找不到信息Id");
                    }
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    ToastUtil.showToast("解析二维码失败");
                }
            }
        }
    }
}
