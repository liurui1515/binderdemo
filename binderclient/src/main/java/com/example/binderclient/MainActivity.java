package com.example.binderclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.binderserver.IMediaService;
import com.example.binderserver.MediaInfo;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "binderclient";
    ServiceConnection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d(TAG, "onServiceConnected");
               IMediaService binder = (IMediaService) iBinder;
                try {
                    Log.d(TAG, "onServiceConnected search invoke");
                    binder.search("忘情水");
                    Log.d(TAG, "onServiceConnected startplay invoke");
                    binder.startplay(new MediaInfo("夜空中最闪亮的星", "xxx", "逃跑计划"));
                    Log.d(TAG, "onServiceConnected stop invoke");
                    binder.stop();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.e(TAG, "onServiceDisconnected");
            }
        };

        Intent intent = new Intent();
        intent.setAction("example.bindertest");
        bindService(intent, conn, BIND_AUTO_CREATE);//开启服务
    }


}
