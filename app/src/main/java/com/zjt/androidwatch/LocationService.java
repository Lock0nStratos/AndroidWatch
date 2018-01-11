package com.zjt.androidwatch;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.google.gson.Gson;
import com.limp.utils.UtilSP;
import com.zjt.androidwatch.bean.LocationBean;

import java.util.ArrayList;
import java.util.List;

public class LocationService extends Service {

    public static String x="";
    public static String y="";
    public static String loctype="";
    List<LocationBean.TagInfoEntity.BluetoothsEntity>list=new ArrayList<>();

    Gson g=new Gson();
    public LocationClient mLocationClient =null;
    public BDLocationListener myListener=new MyLocationListener();
    private int cachetime;
    public LocationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        zzz("开启定位服务");
        cachetime = (int) UtilSP.get(this, "cachetime", 3000);
//        initmap();

        return super.onStartCommand(intent, flags, startId);
    }

    private void initmap() {
        mLocationClient =new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(myListener);
        initlocation();
        mLocationClient.start();
    }

    private void initlocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        //        WGS84
        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系

        int span = 1000;
        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的

        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要

        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        mLocationClient.setLocOption(option);

    }

    void zzz(String s){
        Log.i("zzz", s);
    }

    public class MyLocationListener implements BDLocationListener{

        @Override
        public void onReceiveLocation(BDLocation location) {
            StringBuffer sb=new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());      //获取定位时间

            sb.append("\ntype code : ");
            sb.append(location.getLocType()) ;   //获取类型

            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());   //获取纬度

            sb.append("\nlongtitude ：");
            sb.append(location.getLongitude());  //获取精度

            sb.append("\nradius :");
            sb.append(location.getRadius());     //获取定位精度

            x=location.getLatitude()+"";
            y=location.getLongitude()+"";

            if(location.getLocType()==BDLocation.TypeGpsLocation){
                //GPS定位结果

                sb.append("\nspeed : ");
                sb.append(location.getSpeed());     //单位：公里每小时

                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());       //获取卫星数

                sb.append("\nheight : ");
                sb.append(location.getAltitude());      //获取高度

                sb.append("\ndirection : ");
                sb.append(location.getDirection());     //获取方向信息

                sb.append("\naddr : ");
                sb.append(location.getAddress());       //获取地址信息

                sb.append("\ndescribe : ");
                sb.append("gps定位成功");
                y = location.getLatitude() + "";
                x = location.getLongitude() + "";
                loctype = "GPS";
            }
            else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {

                // 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息

                sb.append("\noperationers : ");
                sb.append(location.getOperators());    //获取运营商信息

                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
                y = location.getLatitude() + "";
                x = location.getLongitude() + "";
                loctype = "网络";
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {

                // 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
                loctype = "离线";
            } else if (location.getLocType() == BDLocation.TypeServerError) {

                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {

                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");

            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {

                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");

            }

            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());    //位置语义化信息

            List<Poi> list = location.getPoiList();    // POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }

            Log.i("BaiduLocationApiDem", sb.toString());
        }
    }
}
