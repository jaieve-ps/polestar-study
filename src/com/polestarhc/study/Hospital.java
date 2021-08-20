package com.polestarhc.study;

public class Hospital implements IExcel {
    private String hospitalName;
    private String hospitalAbbr;
    private String hospitalArea;
    private String hospitalAddress;
    private int bedCount;

    public Hospital() {
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAbbr() {
        return hospitalAbbr;
    }

    public void setHospitalAbbr(String hospitalAbbr) {
        this.hospitalAbbr = hospitalAbbr;
    }

    public String getHospitalArea() {
        return hospitalArea;
    }

    public void setHospitalArea(String hospitalArea) {
        this.hospitalArea = hospitalArea;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    @Override
    public Object getValue(String key) {
        if("hospitalName".equals(key)) {
            return getHospitalName();
        } else if ("hospitalAbbr".equals(key)){
            return getHospitalAbbr();
        } else if ("hospitalArea".equals(key)){
            return getHospitalArea();
        } else if ("hospitalAddress".equals(key)){
            return getHospitalAddress();
        } else if ("bedCount".equals(key)){
            return getBedCount();
        }
        return null;
    }
}
