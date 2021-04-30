package com.cookandroid.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginExam2 extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth; // 파이어베이스 인증
    private DatabaseReference mDatabaseRef; // 실시간 데이터베이스
    private EditText et_loginEmail2, et_loginPassword2; // 로그인 입력필드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_exam2);


        Button btn_loginButton2 = findViewById(R.id.btn_loginButton2);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("JungWooproject");
        et_loginEmail2 = findViewById(R.id.et_loginEmail2);
        et_loginPassword2 = findViewById(R.id.et_loginPassword2);
        btn_loginButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     // 로그인 요청
                String strEmail = et_loginEmail2.getText().toString();
                String strPwd = et_loginPassword2.getText().toString();

                mFirebaseAuth.signInWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(LoginExam2.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            // 로그인 성공
                            Intent intent = new Intent(LoginExam2.this, SuccessLoginExam.class);
                            startActivity(intent);
                            finish(); // 로그인 액티비티를 파괴
                        }
                    }
                });
            }
        });


        Button btn_registerButton2 = findViewById(R.id.btn_registerButton2);
        btn_registerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 회원가입 화면으로 이동
                Intent intent = new Intent(LoginExam2.this, RegisterExam2.class);
                startActivity(intent);

            }
        });
    }
}