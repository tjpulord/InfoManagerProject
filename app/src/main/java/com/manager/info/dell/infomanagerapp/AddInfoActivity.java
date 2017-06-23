package com.manager.info.dell.infomanagerapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.manager.info.dell.infomanagerapp.databinding.ActivityAddInfoBinding;
import com.manager.info.dell.infomanagerapp.db.DBInterface;
import com.manager.info.dell.infomanagerapp.db.InfoEntity;
import com.manager.info.dell.infomanagerapp.util.InjectUtils;
import com.manager.info.dell.infomanagerapp.util.StringUtil;
import com.manager.info.dell.infomanagerapp.util.ToastUtil;

import rx.functions.Action1;

public class AddInfoActivity extends BasicActivity {
    private ActivityAddInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_info);

        initView();
    }

    private void initView() {
        // 取消按钮
        InjectUtils.clicks(binding.btnCancel, new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                onBackPressed();    //返回
            }
        });

        // 保存按钮
        InjectUtils.clicks(binding.btnSave, new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                if (saveInfo()) {
                    ToastUtil.showToast("保存成功");
                    onBackPressed();
                }
            }
        });
    }

    // 保存信息
    private boolean saveInfo() {
        String sn = binding.editInfoId.getText().toString();
        if (StringUtil.isEmpty(sn)) {
            ToastUtil.showToast("保存事变，编号不能为空");
            return false;
        }
        InfoEntity infoEntity = new InfoEntity();
        try {
            infoEntity.setSn(sn);
            infoEntity.setCs_Mobile(binding.editCsMobile.getText().toString());
            infoEntity.setCs_Name(binding.editCsName.getText().toString());
            infoEntity.setDescription(binding.editDescription.getText().toString());
            infoEntity.setManufactures(binding.editManufactures.getText().toString());
            infoEntity.setName(binding.editInfoName.getText().toString());
            DBInterface.instance().insertOrUpdateInfo(infoEntity);
        } catch (Exception e) {
            ToastUtil.showToast("保存失败，" + e.toString());
            return false;
        }
        return true;
    }
}
