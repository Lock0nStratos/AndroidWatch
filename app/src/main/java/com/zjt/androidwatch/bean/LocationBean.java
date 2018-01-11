package com.zjt.androidwatch.bean;

import java.util.List;

/**
 * Created by Y410P on 2018/1/9.
 */

public class LocationBean {
    /**
     * device_id : 设备ID
     * device_info : {"conline_id":"选填-条件路线ID","heart_rate":"选填-手表心率","step_count":"选填-手表步数","useline_id":"选填-使用路ID"}
     * device_type : 0
     * location_info : {"x":"","y":"","z":""}
     * person_id : 人员ID
     * tag_info : {"bluetooths":[{"energy":"3","id":"3","manufacturer":0}],"gps":{"x":"X坐标","y":"Y坐标","z":"Z坐标"},"rfid":"123"}
     * tag_type : 1
     */

    private String device_id;

    public String getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(String heartrate) {
        this.heartrate = heartrate;
    }

    private String heartrate;

    /**
     * conline_id:条件线路ID
     * heart_rate:手环心率
     * step_count:手环步数
     * useline_id:使用路线ID
     */
    private String device_info;
    private int device_type;

    /**
     * x:
     * y:
     * z:
     */
    private LocationInfoEntity location_info;
    private String person_id;

    /**bluetooths:[{"energy":"3","id":"3","manufacturer":0}]
     * gps:{"x":"X坐标","y":"Y坐标","z":"Z坐标"}
     * rfid:123
     */
    private TagInfoEntity tag_info;
    private int tag_type;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public int getDevice_type() {
        return device_type;
    }

    public void setDevice_type(int device_type) {
        this.device_type = device_type;
    }

    public LocationInfoEntity getLocation_info() {
        return location_info;
    }

    public void setLocation_info(LocationInfoEntity location_info) {
        this.location_info = location_info;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public TagInfoEntity getTag_info() {
        return tag_info;
    }

    public void setTag_info(TagInfoEntity tag_info) {
        this.tag_info = tag_info;
    }

    public int getTag_type() {
        return tag_type;
    }

    public void setTag_type(int tag_type) {
        this.tag_type = tag_type;
    }

    public static class DeviceInfoEntity{
        private String conline_id;

        public String getConline_id() {
            return conline_id;
        }

        public void setConline_id(String conline_id) {
            this.conline_id = conline_id;
        }

        public String getHeart_rate() {
            return heart_rate;
        }

        public void setHeart_rate(String heart_rate) {
            this.heart_rate = heart_rate;
        }

        public String getStep_count() {
            return step_count;
        }

        public void setStep_count(String step_count) {
            this.step_count = step_count;
        }

        public String getUseline_id() {
            return useline_id;
        }

        public void setUseline_id(String useline_id) {
            this.useline_id = useline_id;
        }

        private String heart_rate;
        private String step_count;
        private String useline_id;
    }

    public static class LocationInfoEntity{
        private String x="";
        private String y="";
        private String z="";

        public String getX() {
            return x;
        }

        public void setX(String x) {
            this.x = x;
        }

        public String getY() {
            return y;
        }

        public void setY(String y) {
            this.y = y;
        }

        public String getZ() {
            return z;
        }

        public void setZ(String z) {
            this.z = z;
        }
    }

    public static class TagInfoEntity{
        /**
         * x : X坐标
         * y : Y坐标
         * z : Z坐标
         */

        private GpsEntity gps;

        private String rfid;

        /**
         * energy : 3
         * id : 3
         * manufacturer : 0
         */
        private List<BluetoothsEntity>bluetooths;

        public GpsEntity getGps() {
            return gps;
        }

        public void setGps(GpsEntity gps) {
            this.gps = gps;
        }

        public String getRfid() {
            return rfid;
        }

        public void setRfid(String rfid) {
            this.rfid = rfid;
        }

        public List<BluetoothsEntity> getBluetooths() {
            return bluetooths;
        }

        public void setBluetooths(List<BluetoothsEntity> bluetooths) {
            this.bluetooths = bluetooths;
        }

        public static class BluetoothsEntity{
            private String energy;
            private String id;

            public String getEnergy() {
                return energy;
            }

            public void setEnergy(String energy) {
                this.energy = energy;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getManufacturer() {
                return manufacturer;
            }

            public void setManufacturer(int manufacturer) {
                this.manufacturer = manufacturer;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            private int manufacturer;
            private long time;
        }

    }

    public static class GpsEntity{
        private String x;
        private String y;
        private String z;

        public String getX() {
            return x;
        }

        public void setX(String x) {
            this.x = x;
        }

        public String getY() {
            return y;
        }

        public void setY(String y) {
            this.y = y;
        }

        public String getZ() {
            return z;
        }

        public void setZ(String z) {
            this.z = z;
        }
    }


}
