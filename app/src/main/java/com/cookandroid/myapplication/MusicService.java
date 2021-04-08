package com.cookandroid.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() { // 서비스가 시작될때 초기화
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this, R.raw.acoustic);
        mediaPlayer.setLooping(false); // 반복재생을 할 건지 안할건지의 여부
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() { // 서비스가 끝날때 종료
        super.onDestroy();

        mediaPlayer.stop();
    }

}
