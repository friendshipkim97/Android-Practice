package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivityForResultExam extends AppCompatActivity {

    private EditText et_comeback;
    private Button btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_for_result_exam);

        et_comeback = findViewById(R.id.et_comeback);
        btn_close = findViewById(R.id.btn_close);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("comeback", et_comeback.getText().toString()); // name은 id값이다 돌아갈거에도 id맞춰줘야 함
                setResult(RESULT_OK, intent); // 결과 값 설정
                finish(); // 현재 액티비티 종료시킬 때 쓰여지는 메서드이다.
                 }
        });
    }
}
