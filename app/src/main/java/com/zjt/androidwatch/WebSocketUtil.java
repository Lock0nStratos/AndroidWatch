package com.zjt.androidwatch;

import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.nio.channels.NotYetConnectedException;

/**
 * Created by Limp on 2017/8/28.
 */

public class WebSocketUtil extends WebSocketClient {

    //    static String ip = "ws://10.238.18.59:8010/WebSocket";
    //本地ip
//    static String ip = "ws://192.168.11.76:8010/WebSockethandler.ashx";
//西安外网端口
    static String ip = "ws://202.96.41.40:8010/WebSockethandler.ashx";

    TCPCallBack a;

    /**
     * 标准化，可配置
     * 公网展示
     * 双机热备，web socket
     * 市场分析
     */
    public WebSocketUtil(URI serverURI, TCPCallBack a) {
        super(serverURI);
        this.a = a;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        Log.i("zzz", "WebSocket--链接成功");
        a.success();
    }

    @Override
    public void onMessage(String s) {
        a.message(s);
    }

    @Override
    public void send(String text) throws NotYetConnectedException {
        Log.i("zzz", "WebSocket--发送数据:" + text);
        super.send(text);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        Log.i("zzz", "WebSocket--链接关闭");
    }

    @Override
    public void onError(Exception e) {
        Log.i("zzz", "WebSocket--链接失败,原因:" + e.toString());
        a.fall();
    }

    public interface TCPCallBack {
        void success();

        void fall();

        void message(String s);
    }
}
