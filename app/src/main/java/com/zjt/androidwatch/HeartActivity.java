package com.zjt.androidwatch;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.eclipse.paho.client.mqttv3.MqttClient;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HeartActivity extends AppCompatActivity {
    public static String deviceid = "操作人员";
    public static int heart = 0;
    public static double longitude;
    public static double latitude;
    public static ImageView img_gps;
    public static ImageView img_bl;
    public static HeartActivity context;
    private MqttClient sampleClient;
    TextView tv_time;
    public static Gson g;
    private TextView tv_heart;
    private Vibrator vib;
    private TextView tv_name;
    private SimpleDateFormat sdf;
    private Date d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);
    }
}
