package com.manager.info.dell.infomanagerapp;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.manager.info.dell.infomanagerapp.db.InfoEntity;
import com.manager.info.dell.infomanagerapp.util.StringUtil;

import java.util.List;

/**
 * Description
 * <p>
 * Created by Liu Huanbin
 * 2017/6/23
 */

public class DeviceInfoAdapter extends BaseQuickAdapter<InfoEntity, BaseViewHolder> {
    public DeviceInfoAdapter(int layoutResId, List<InfoEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, InfoEntity infoEntity) {
        baseViewHolder.setText(R.id.tv_info_id, infoEntity.getSn());
        if (!StringUtil.isEmpty(infoEntity.getName())) {
            baseViewHolder.setText(R.id.tv_info_name, infoEntity.getName());
        }
        if (!StringUtil.isEmpty(infoEntity.getManufactures())) {
            baseViewHolder.setText(R.id.tv_manufacture, infoEntity.getManufactures());
        }
    }

}
