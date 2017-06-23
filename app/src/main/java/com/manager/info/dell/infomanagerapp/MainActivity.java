package com.manager.info.dell.infomanagerapp;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.manager.info.dell.infomanagerapp.databinding.ActivityMainBinding;

public class MainActivity extends BasicActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initView();
    }

    private void initView(){
        binding.ivRecordInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_record_info:
                jumpActivity(CreateInfoActivity.class);
                break;
            case R.id.iv_search_info:
                break;
            default:
                break;
        }
    }
}
