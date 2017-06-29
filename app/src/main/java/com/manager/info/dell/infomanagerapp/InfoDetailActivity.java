package com.manager.info.dell.infomanagerapp;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.manager.info.dell.infomanagerapp.databinding.ActivityInfoDetailBinding;
import com.manager.info.dell.infomanagerapp.db.DBInterface;
import com.manager.info.dell.infomanagerapp.db.InfoEntity;
import com.manager.info.dell.infomanagerapp.util.ConstantUtil;
import com.manager.info.dell.infomanagerapp.util.InjectUtils;
import com.manager.info.dell.infomanagerapp.util.StringUtil;
import com.manager.info.dell.infomanagerapp.util.ToastUtil;

import java.util.HashMap;
import java.util.Map;

import rx.functions.Action1;

public class InfoDetailActivity extends BasicActivity {
    private ActivityInfoDetailBinding binding;
    private String sn;
    private InfoEntity infoEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_info_detail);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            sn = bundle.getString(ConstantUtil.INFO_SN);
        }
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initInfoData();
    }

    private void initView() {
        InjectUtils.clicks(binding.btnCancel, new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                onBackPressed();
            }
        });

        InjectUtils.clicks(binding.btnEdit, new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Bundle bundle = new Bundle();
                bundle.putString(ConstantUtil.INFO_SN, sn);
                jumpActivity(getApplicationContext(), AddInfoActivity.class, bundle);
            }
        });

        InjectUtils.clicks(binding.ibtnErweima, new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Bitmap bitmap = generateBitmap("http://localhost/sample.php?sn="+sn, 200, 200);
                if (bitmap != null) {
                    binding.ivErweima.setVisibility(View.VISIBLE);
                    binding.ivErweima.setImageBitmap(bitmap);
                }
            }
        });

        InjectUtils.clicks(binding.btnDel, new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                DBInterface.instance().deleteInfoByUniqueId(infoEntity.getId());
                ToastUtil.showToast(String.format("已删除信息：%s(%s)", infoEntity.getName(), infoEntity.getSn()));
                onBackPressed();
            }
        });
    }

    private void initInfoData() {
        if (sn == null) {
            binding.btnEdit.setEnabled(false);
            binding.ibtnErweima.setEnabled(false);
            binding.btnDel.setEnabled(false);
            ToastUtil.showToast("获取信息编号失败");
            return;
        }
        infoEntity = DBInterface.instance().queryInfoByUniqueId(sn);
        if (infoEntity != null) {
            binding.tvInfoId.setText(infoEntity.getSn());
            if (!StringUtil.isEmpty(infoEntity.getCs_Mobile())) {
                binding.tvCsMobile.setText(infoEntity.getCs_Mobile());
            }
            if (!StringUtil.isEmpty(infoEntity.getManufactures())) {
                binding.tvManufactures.setText(infoEntity.getManufactures());
            }
            if (!StringUtil.isEmpty(infoEntity.getName())) {
                binding.tvInfoName.setText(infoEntity.getName());
            }
            if (!StringUtil.isEmpty(infoEntity.getDescription())) {
                binding.tvDescription.setText(infoEntity.getDescription());
            }
            if (!StringUtil.isEmpty(infoEntity.getCs_Name())) {
                binding.tvCsName.setText(infoEntity.getCs_Name());
            }
        } else {
            ToastUtil.showToast("找不到该信息，信息编号："+sn);
            this.onBackPressed();
        }

    }


    private Bitmap generateBitmap(String content, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            BitMatrix encode = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            int[] pixels = new int[width * height];
            for (int i=0; i<height; i++) {
                for (int j=0; j<width; j++) {
                    if (encode.get(j,i)) {
                        pixels[i*width + j] = 0x00000000;
                    } else {
                        pixels[i*width + j] = 0xffffffff;
                    }
                }
            }
            return Bitmap.createBitmap(pixels, 0, width, width, height, Bitmap.Config.RGB_565);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBackPressed() {
        if (binding.ivErweima.getVisibility() == View.VISIBLE) {
            binding.ivErweima.setVisibility(View.GONE);
            return;
        }
        super.onBackPressed();
    }
}
