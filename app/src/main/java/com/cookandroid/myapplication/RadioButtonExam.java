package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonExam extends AppCompatActivity {

    private RadioGroup rb_gender;
    private RadioButton rb_man, rb_woman;
    private Button btn_result;
    private String str_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_exam);

        rb_gender = findViewById(R.id.rg_gender); // 라디오 버튼들을 담고있는 그룹
        rb_man = findViewById(R.id.rb_man);
        rb_woman = findViewById(R.id.rb_woman);
        btn_result = findViewById(R.id.btn_result); // 결과 값을 출력하라는 신호를 보낼 버튼

        rb_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rb_man){
                    Toast.makeText(RadioButtonExam.this, "남자 라디오 버튼", Toast.LENGTH_SHORT).show();
                    str_result = rb_man.getText().toString();
                } else if(i == R.id.rb_woman){
                    Toast.makeText(RadioButtonExam.this, "여자 라디오 버튼", Toast.LENGTH_SHORT).show();
                    str_result = rb_woman.getText().toString();
                }
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(str_result != null) { // str result가 빈 값이 아니라면..
                   Toast.makeText(RadioButtonExam.this, str_result, Toast.LENGTH_SHORT).show();
                } else { // str result가 빈 값일 경우
                    Toast.makeText(RadioButtonExam.this, "라디오 버튼을 선택해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}