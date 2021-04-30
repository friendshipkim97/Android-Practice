package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SuccessLoginExam extends AppCompatActivity {

private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_login_exam);

        mFirebaseAuth = FirebaseAuth.getInstance();

        Button btn_logout2 = findViewById(R.id.btn_logout2);
        btn_logout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 로그아웃 하기
                mFirebaseAuth.signOut();
                Intent intent = new Intent(SuccessLoginExam.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 회원 탈퇴 처리
        // mFirebaseAuth.getCurrentUser().delete();
    }
}