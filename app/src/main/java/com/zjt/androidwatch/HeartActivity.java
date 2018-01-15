package com.zjt.androidwatch;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.skybeacon.sdk.locate.SKYBeaconManager;

import org.eclipse.paho.client.mqttv3.MqttClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

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
    /**心跳传感器监听器*/
    private SensorEventListener myheartSensorListener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.values[0]!=0&&heart!=(int)event.values[0]){
                heart=(int)event.values[0];
                h.sendEmptyMessage(heart);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    /**
     * 其他线程通过sendmessage()将数据通过msg作为参数传入，在主线程中修改UI
     */
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int what=msg.what;

            tv_heart.setText(""+what);
            d.setTime(SystemClock.currentThreadTimeMillis());
            tv_time.setText(sdf.format(new Date()));
        }
    };
    private SensorManager sm;
    private WebSocketUtil webSocket;
    Timer t;
    Timer heart_timer=new Timer();

    /**
     * 音频
     * */
    private ImageView img_talk;

    private String voice_path = "";
    private MediaRecorder mRecorder;
    private MediaPlayer mPlayer;
    private TextView tv_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);

        /**
         * 保持亮屏幕
         */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        deviceid=getIntent().getStringExtra("name");
        SKYBeaconManager.getInstance().init(this);
        SKYBeaconManager.getInstance().setScanTimerIntervalMillisecond(1000);
        startService(new Intent(this,LocationService.class));
        initView();
    }

    private void initView() {
        sdf=new SimpleDateFormat("HH:mm");
        d=new Date();
        g=new Gson();
        context=this;

    }
}
