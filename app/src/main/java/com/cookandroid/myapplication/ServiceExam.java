package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceExam extends AppCompatActivity {

    Button btn_serviceStart, btn_serviceStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_exam);

        btn_serviceStart = (Button)findViewById(R.id.btn_serviceStart);
        btn_serviceStop = (Button)findViewById(R.id.btn_serviceStop);

        btn_serviceStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startService(new Intent(getApplicationContext(), MusicService.class));
            }
        });

        btn_serviceStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(getApplicationContext(), MusicService.class));
            }
        });

    }
}
