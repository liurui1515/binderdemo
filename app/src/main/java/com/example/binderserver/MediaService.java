package com.example.binderserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

public class MediaService extends Service {
    private static final String TAG = "MediaService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return (IBinder) mBinder;
    }

    private IMediaService mBinder = new IMediaService.Stub() {
        @Override
        public void startplay(MediaInfo info) throws RemoteException {
            Log.d(TAG, "startplay mediaInfo =" + info.toString());
        }

        @Override
        public void stop() throws RemoteException {
            Log.d(TAG, "service stop  ");
        }

        @Override
        public void search(String name) throws RemoteException {
            Log.d(TAG, "service search name=" + name);
        }
    };
}
