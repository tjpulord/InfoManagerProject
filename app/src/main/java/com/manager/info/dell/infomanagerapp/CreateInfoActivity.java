package com.manager.info.dell.infomanagerapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.manager.info.dell.infomanagerapp.databinding.ActivityCreateInfoBinding;
import com.manager.info.dell.infomanagerapp.db.DBInterface;
import com.manager.info.dell.infomanagerapp.db.InfoEntity;
import com.manager.info.dell.infomanagerapp.util.ConstantUtil;
import com.manager.info.dell.infomanagerapp.util.InjectUtils;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Action1;

public class CreateInfoActivity extends BasicActivity {
    private ActivityCreateInfoBinding binding;
    private DeviceInfoAdapter infoAdapter;
    private List<InfoEntity> infoEntityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_info);

//        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
    }

    private void initView() {
        infoEntityList = DBInterface.instance().queryAllInformations();
        if (infoEntityList == null) {
            infoEntityList = new ArrayList<>();
        }
        infoAdapter = new DeviceInfoAdapter(R.layout.item_info_show, infoEntityList);
        binding.rcyInfoList.setLayoutManager(new LinearLayoutManager(this));
        binding.rcyInfoList.setAdapter(infoAdapter);
        View v = getLayoutInflater().inflate(R.layout.item_info_show, null);
        v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        infoAdapter.addHeaderView(v);

        binding.rcyInfoList.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                InfoEntity entity = infoEntityList.get(i);
                Bundle bundle = new Bundle();
                bundle.putString(ConstantUtil.INFO_SN, entity.getSn());
                jumpActivity(InfoDetailActivity.class, bundle);
            }
        });

        InjectUtils.clicks(binding.btnAddFile, new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                jumpActivity(AddInfoActivity.class);
            }
        });
    }
}
