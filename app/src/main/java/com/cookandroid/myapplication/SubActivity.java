package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView tv_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_sub = findViewById(R.id.tv_sub);

        Intent intent = getIntent(); // 어디서 날라오는 데이터 값이 있으면 이걸로 받는다.
        String str = intent.getStringExtra("str"); // 데이터를 보낼때와 받는 이름이 같아야 한다.

        tv_sub.setText(str);
    }
}
