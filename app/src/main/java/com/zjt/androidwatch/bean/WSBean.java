package com.zjt.androidwatch.bean;

/**
 * Created by Y410P on 2018/1/8.
 */

public class WSBean {
    /**
     * data:手环01在***呼救
     * dataType:103
     * deviceId:手环01
     * heartRate:0
     */

    private String data;
    private String dataType;
    private String deviceId;
    private String heartRate;

    public WSBean(String data,String dataType,String deviceId,String heartRate){
        this.data=data;
        this.dataType=dataType;
        this.deviceId=deviceId;
        this.heartRate=heartRate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }
}
