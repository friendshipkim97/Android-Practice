package com.cookandroid.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThreadExam extends AppCompatActivity { // 앱에서 잠깐 나와있을때 백그라운드상태인데 그 때 처리를 해주는것이 스레드

    Button btn_threadStart, btn_threadStop;
    Thread thread;
    boolean isThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_exam);

        // 스레드 시작
        btn_threadStart = (Button) findViewById(R.id.btn_threadStart);
        btn_threadStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isThread = true;
                thread = new Thread() {

                    public void run() {
                        while (isThread) { // true인 동안에는 계속 돌게함
                            try {
                                sleep(5000); // 5초동안 쉬기
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.sendEmptyMessage(0); // 5초 동안 쉬었다가 이 메서드를 실행하는 것, 메서드를 실행하면 아래의 Toast메세지가 실행됨
                        }

                    }
                };
                thread.start();

            }
        });

        // 스레드 종료
        btn_threadStop = (Button) findViewById(R.id.btn_threadStop);
        btn_threadStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isThread = false;
            }
        });
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Toast.makeText(getApplicationContext(), "정우", Toast.LENGTH_SHORT).show();
        }
    };
}
