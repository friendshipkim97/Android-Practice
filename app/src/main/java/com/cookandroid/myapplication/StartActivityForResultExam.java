package com.cookandroid.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivityForResultExam extends AppCompatActivity {

    private TextView tv_comeback;
    private Button btn_go;

    private static final int REQUEST_CODE = 777; // 상수 값을 선언 + 상수(항상 같은 수 + 변하지 않을 수 )

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // 이 화면에 진입했을때 가장먼저 실행되는 메서드
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result_exam);

        tv_comeback = findViewById(R.id.tv_comeback);
        btn_go = findViewById(R.id.btn_go);

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivityForResultExam.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { // 이쪽에서 값을 받는다.
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Toast.makeText(getApplicationContext(), "수신 성공", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "수신 실패", Toast.LENGTH_SHORT).show();
        }

        if(requestCode == REQUEST_CODE){
            String resultTxt = data.getStringExtra("comeback"); // SubActivityForReusultExam클래스에서 적은 name과 맞춰준다.
            tv_comeback.setText(resultTxt);
        }
    }
}
