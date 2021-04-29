package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

public class GoogleLoginResultActiviy extends AppCompatActivity {

    private TextView tv_googleLoginNickName; // 닉네임 Text
    private ImageView iv_googleLoginprofile;
    private Button btn_googleLogout2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_login_result_activiy);

        Intent intent = getIntent();
        String nickName = intent.getStringExtra("nickName"); // MainActivity로 부터 닉네임 전달받음
        String photoUrl = intent.getStringExtra("photoUrl"); // MainActivity로 부터 프로필사진 Url 전달받음

        tv_googleLoginNickName = findViewById(R.id.tv_googleLoginNickName);
        tv_googleLoginNickName.setText(nickName); // 닉네임 text를 텍스트뷰에 세팅

        iv_googleLoginprofile = findViewById(R.id.iv_googleLoginprofile);
        Glide.with(this).load(photoUrl).into(iv_googleLoginprofile); // 프로필 url을 이미지 뷰에 세팅

        btn_googleLogout2 = findViewById(R.id.btn_googleLogout2);
        btn_googleLogout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(GoogleLoginResultActiviy.this, GoogleLoginExam.class);
                startActivity(intent);
            }
        });
    }
}