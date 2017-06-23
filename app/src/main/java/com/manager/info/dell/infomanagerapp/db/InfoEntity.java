package com.manager.info.dell.infomanagerapp.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * 信息实体类
 * <p>
 * Created by Liu Huanbin
 * 2017/6/22
 */
@Entity
public class InfoEntity {
    @Id
    private Long id;
    @Unique
    private String sn;
    private String name;
    private String imageUrl;
    private String description;
    private String manufactures;
    private String cs_Mobile;
    private String cs_Name;

    @Generated(hash = 233272084)
    public InfoEntity(Long id, String sn, String name, String imageUrl,
            String description, String manufactures, String cs_Mobile,
            String cs_Name) {
        this.id = id;
        this.sn = sn;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.manufactures = manufactures;
        this.cs_Mobile = cs_Mobile;
        this.cs_Name = cs_Name;
    }

    @Generated(hash = 1162301232)
    public InfoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufactures() {
        return manufactures;
    }

    public void setManufactures(String manufactures) {
        this.manufactures = manufactures;
    }

    public String getCs_Mobile() {
        return cs_Mobile;
    }

    public void setCs_Mobile(String cs_Mobile) {
        this.cs_Mobile = cs_Mobile;
    }

    public String getCs_Name() {
        return cs_Name;
    }

    public void setCs_Name(String cs_Name) {
        this.cs_Name = cs_Name;
    }
}
