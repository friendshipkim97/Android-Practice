package com.cookandroid.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

// Service 컴포넌트는 Activity처럼 사용자와 상호작용하는 컴포넌트가 아니고, 백그라운드에서 동작하는 컴포넌트이다.
// Activity 화면에서 동작할 뿐 아니라, Activity가 종료되어 있는 상태에서도 동작하게 만들어진 컴포넌트. ex) mp3
public class MusicService extends Service {

    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // Service 주기는 onCreate() -> onStartCommand() 순으로 이뤄 진다.
    @Override
    public void onCreate() { // 서비스가 시작될때 초기화
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this, R.raw.acoustic);
        mediaPlayer.setLooping(false); // 반복재생을 할 건지 안할건지의 여부
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId); // return 값에 따라 메모리 부족현상이 발생했을 때 Service가 죽고 메모리 여유가 생겨 다시 start 되었을 때 동작 정의 가능
    }

    @Override
    public void onDestroy() { // 서비스가 끝날때 종료
        super.onDestroy();
        mediaPlayer.stop();
    }

}
