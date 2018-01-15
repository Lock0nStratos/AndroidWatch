package com.zjt.androidwatch.bean;

/**
 * Created by Limp on 2017/2/13.
 */

public class DeviceHandBean {

    /**
     * result : 1
     * data : {"DEVICE_ID":"WCRJKF01","HAND_CODE":"0f0649d4df65c545","HAND_NAME":"外操软件开发测试1","HAND_AVATAR":"Img/man.jpg","MANUFACTURER":"石化盈科","PRODUCT_TIME":"2017-04-03 16:00:00","GROUP_IP":"","CONFIG":""}
     * message : 成功
     */

    private String result;
    /**
     * DEVICE_ID : WCRJKF01
     * HAND_CODE : 0f0649d4df65c545
     * HAND_NAME : 外操软件开发测试1
     * HAND_AVATAR : Img/man.jpg
     * MANUFACTURER : 石化盈科
     * PRODUCT_TIME : 2017-04-03 16:00:00
     * GROUP_IP :
     * CONFIG :
     */

    private DataEntity data;
    private String message;

    public void setResult(String result) {
        this.result = result;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public DataEntity getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public static class DataEntity {
        private String DEVICE_ID;
        private String HAND_CODE;
        private String HAND_NAME;
        private String HAND_AVATAR;
        private String MANUFACTURER;
        private String PRODUCT_TIME;
        private String GROUP_IP;
        private String CONFIG;

        public void setDEVICE_ID(String DEVICE_ID) {
            this.DEVICE_ID = DEVICE_ID;
        }

        public void setHAND_CODE(String HAND_CODE) {
            this.HAND_CODE = HAND_CODE;
        }

        public void setHAND_NAME(String HAND_NAME) {
            this.HAND_NAME = HAND_NAME;
        }

        public void setHAND_AVATAR(String HAND_AVATAR) {
            this.HAND_AVATAR = HAND_AVATAR;
        }

        public void setMANUFACTURER(String MANUFACTURER) {
            this.MANUFACTURER = MANUFACTURER;
        }

        public void setPRODUCT_TIME(String PRODUCT_TIME) {
            this.PRODUCT_TIME = PRODUCT_TIME;
        }

        public void setGROUP_IP(String GROUP_IP) {
            this.GROUP_IP = GROUP_IP;
        }

        public void setCONFIG(String CONFIG) {
            this.CONFIG = CONFIG;
        }

        public String getDEVICE_ID() {
            return DEVICE_ID;
        }

        public String getHAND_CODE() {
            return HAND_CODE;
        }

        public String getHAND_NAME() {
            return HAND_NAME;
        }

        public String getHAND_AVATAR() {
            return HAND_AVATAR;
        }

        public String getMANUFACTURER() {
            return MANUFACTURER;
        }

        public String getPRODUCT_TIME() {
            return PRODUCT_TIME;
        }

        public String getGROUP_IP() {
            return GROUP_IP;
        }

        public String getCONFIG() {
            return CONFIG;
        }
    }
}
