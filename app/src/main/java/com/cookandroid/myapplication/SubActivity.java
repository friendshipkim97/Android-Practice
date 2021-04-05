package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView tv_sub;
    public Button navigateMoveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        init();
        navigateMove();

        Intent intent = getIntent(); // 어디서 날라오는 데이터 값이 있으면 이걸로 받는다.
        String str = intent.getStringExtra("str"); // 데이터를 보낼때와 받는 이름이 같아야 한다.
        tv_sub.setText(str);

    }


    private void init(){
        tv_sub = findViewById(R.id.tv_sub);
        navigateMoveBtn = findViewById(R.id.navigateMoveBtn);
    }

    private void navigateMove() {
        navigateMoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this, NavigateMenu.class);
                startActivity(intent);
            }
        });
    }

//    private void buttonMove() {
//        btn_move.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, SubActivity.class);
//                str = et_test.getText().toString();
//                intent.putExtra("str", str);
//                startActivity(intent); // 액티비티 이동
//            }
//        });
//    }
}
