package com.haier.m.entity.region;

import java.io.Serializable;

/**
 * Created by 11150721040285 on 2016/9/10.
 */
public class PcrsRegion  implements Serializable{
    private String provinceId;

    private String cityId;

    private String regionId;

    private String streetId;

    private String name;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getStreetId() {
        return streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
