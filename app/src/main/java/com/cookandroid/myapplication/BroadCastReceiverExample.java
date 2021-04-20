package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

public class BroadCastReceiverExample extends AppCompatActivity{

    public static TextView tv_state;
    private NetworkReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver_example);

        tv_state = findViewById(R.id.tv_state);

        // 브로드 캐스트 리시버 등록
        IntentFilter filter = new IntentFilter(); // Intent에는 2가지가 있다 명시적(그동안썼던 Intent, 목적이 뚜렷함), 암시적(특정 구성 요소의 이름을 대지 않는다.)
        receiver = new NetworkReceiver();
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(receiver, filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 브로드 캐스트 리시버 해제!
        unregisterReceiver(receiver);
    }
}
