package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckBoxExam extends AppCompatActivity {

    private CheckBox chk_red, chk_blue, chk_green;
    private TextView tv_result;
    private Button btn_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_exam);

        chk_red= findViewById(R.id.chk_red);
        chk_blue= findViewById(R.id.chk_blue);
        chk_green= findViewById(R.id.chk_green);
        tv_result= findViewById(R.id.tv_result);
        btn_result= findViewById(R.id.btn_result);

        btn_result.setOnClickListener(new View.OnClickListener() { // 결과 버튼을 클릭했을 때 액션
            @Override
            public void onClick(View view) {
                String str_result = ""; // String 값 초기화
                if(chk_red.isChecked()){
                    str_result += chk_red.getText().toString();
                }
                if(chk_blue.isChecked()){
                    str_result += chk_blue.getText().toString();
                }
                if(chk_green.isChecked()){
                    str_result += chk_green.getText().toString();
                }

                tv_result.setText(str_result);
            }
        });

    }
}