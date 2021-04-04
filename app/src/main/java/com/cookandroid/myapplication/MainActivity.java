package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_id;
//    Button btn_test;
    ImageView test;

    private Button btn_move;
    private EditText et_test;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_test = findViewById(R.id.et_test);


        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent intent = new Intent(MainActivity.this, SubActivity.class);
                  str = et_test.getText().toString();
                  intent.putExtra("str", str);
                  startActivity(intent); // 액티비티 이동
            }
        });

        test = (ImageView)findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "김정우짱", Toast.LENGTH_SHORT).show();
            }
        });

//        et_id = findViewById(R.id.et_id);
//        btn_test = findViewById(R.id.btn_test);
//
//        btn_test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                et_id.setText("김정우");
//            }
//        });
    }


}
