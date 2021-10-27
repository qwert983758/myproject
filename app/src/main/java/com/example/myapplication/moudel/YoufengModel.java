package com.example.myapplication.moudel;

public class YoufengModel extends BaseModel {
    //型号、价格、数量、位置、摘要
    //型号宽
    private String mModelWith = "";
    //型号高
    private String mModelHeight = "";
    //型号长
    private String mModelLength = "";
    //单价
    private double mPrice = 0.0;
    //数量
    private int mNum = 0;
    //位置
    private String mLocation = "";
    //适用类型
    private String mBeApplicable = "";
    //其他信息
    private String mSummary = "";

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        this.mPrice = price;
    }

    public String getModelWith() {
        return mModelWith;
    }

    public void setModelHeight(String model) {
        this.mModelHeight = model;
    }

    public String getModelHeight() {
        return mModelHeight;
    }

    public void setModelLength(String model) {
        this.mModelLength = model;
    }

    public String getModelLength() {
        return mModelLength;
    }

    public void setModelWith(String model) {
        this.mModelWith = model;
    }

    public int getNum() {
        return mNum;
    }

    public void setNum(int num) {
        this.mNum = num;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        this.mLocation = location;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        this.mSummary = summary;
    }

    public String getBeApplicable() {
        return mBeApplicable;
    }

    public void setBeApplicable(String beApplicable) {
        this.mBeApplicable = beApplicable;
    }
}
