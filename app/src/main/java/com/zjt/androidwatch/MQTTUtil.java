package com.zjt.androidwatch;

import com.google.gson.Gson;
import com.zjt.androidwatch.bean.HandBean;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.limp.utils.L.zzz;

/**
 * Created by Limp on 2017/1/18.
 */

public class MQTTUtil {
    static MQTTUtil mQTTUtil;
    private MqttClient sampleClient;
    private String ip = "tcp://10.238.255.93:1883";
    public String token = "VaFyFNIo8f6ccpLvmkgG";
    private SimpleDateFormat sf;
    Gson g;

    public static MQTTUtil getincetense() {
        if (mQTTUtil == null) {
            mQTTUtil = new MQTTUtil();
        }
        return mQTTUtil;
    }

    public void uploadheartrate(String s) {
        if (sampleClient != null) {
            Data d = new Data();
            d.lat = LocationService.y;
            d.lng = LocationService.x;
            zzz("x=" + LocationService.x + ",Y=" + LocationService.y);
            d.heartrate = s;
            d.objectCode = "1";
            d.objectType = "2";
            sendmessage(g.toJson(new HandBean(gettime(), g.toJson(d))));
        }
    }

    public void initconnet() {
        String clientId = "eb4b9190-bed1-11e7-a9f7-09036b320ab9";
        MemoryPersistence persistence = new MemoryPersistence();
        sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        g = new Gson();
        try {
            sampleClient = new MqttClient(ip, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setKeepAliveInterval(30);
            connOpts.setUserName(token);
            zzz("Connecting to broker: " + ip);
            sampleClient.connect(connOpts);
            zzz("MQTT链接成功!");
        } catch (MqttException me) {
            zzz("reason " + me.getReasonCode());
            zzz("msg " + me.getMessage());
            zzz("loc " + me.getLocalizedMessage());
            zzz("cause " + me.getCause());
            zzz("excep " + me);
            me.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendmessage(String s) {
        if (sampleClient != null) {
            zzz(s);
            MqttMessage message = new MqttMessage(s.getBytes());
            message.setQos(0);
            try {
                sampleClient.publish("v1/devices/me/telemetry", message);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    public String gettime() {
        Date d = new Date();
        return sf.format(d);
    }

    public void close() {
        if (sampleClient != null) {
            try {
                sampleClient.close();
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }

    }

    public class Data {
        String lat;
        String lng;
        //        String temperature;
        String heartrate;
        String objectCode;
        String objectType;
    }
}
