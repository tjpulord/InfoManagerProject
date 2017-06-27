package com.manager.info.dell.infomanagerapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.manager.info.dell.infomanagerapp.util.ImageUtil;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class MyScanUIActivity extends BasicActivity implements View.OnClickListener{
    private boolean isOpen =false;
    private CaptureFragment captureFragment;
    private final int REQUEST_IMAGE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_scan_ui);

        findViewById(R.id.icon_light).setOnClickListener(this);
        findViewById(R.id.icon_picture).setOnClickListener(this);

        captureFragment = new CaptureFragment();
        CodeUtils.setFragmentArgs(captureFragment, R.layout.customer_camera);
        captureFragment.setAnalyzeCallback(analyzeCallback);
//        captureFragment.
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();
    }



    private CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
            bundle.putString(CodeUtils.RESULT_STRING, result);
            intent.putExtras(bundle);
            MyScanUIActivity.this.setResult(RESULT_OK, intent);
            MyScanUIActivity.this.finish();
        }

        @Override
        public void onAnalyzeFailed() {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            intent.putExtras(bundle);
            MyScanUIActivity.this.setResult(RESULT_OK, intent);
            MyScanUIActivity.this.finish();
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon_light:
                CodeUtils.isLightEnable(!isOpen);
                break;
            case R.id.icon_picture:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_IMAGE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE) {
            if (data != null) {
                Uri uri = data.getData();
                try {
                    CodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(this, uri), analyzeCallback);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
