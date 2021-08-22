package com.polestarhc.study;

import java.util.HashMap;
import java.util.Map;

public class Hospital implements IExcel {
    private final Map<String, Object> map = new HashMap<>();
    public Hospital() {}

    public void setHospitalName(String hospitalName) {
        this.map.put("hospitalName", hospitalName);
    }

    public void setHospitalAbbr(String hospitalAbbr) {
        this.map.put("hospitalAbbr", hospitalAbbr);
    }

    public void setHospitalArea(String hospitalArea) {
        this.map.put("hospitalArea", hospitalArea);
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.map.put("hospitalAddress", hospitalAddress);
    }

    public void setBedCount(int bedCount) {
        this.map.put("bedCount", bedCount);
    }

    @Override
    public Object getValue(String key) {
        return map.get(key);
    }
}
