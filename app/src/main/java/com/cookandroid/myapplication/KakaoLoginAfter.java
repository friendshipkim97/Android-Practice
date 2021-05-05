package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

public class KakaoLoginAfter extends AppCompatActivity {

    private String strNick, strProfileImg, strEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao_login_after);

        Intent intent = getIntent();
        strNick = intent.getStringExtra("name");
        strEmail = intent.getStringExtra("email");
        strProfileImg = intent.getStringExtra("profileImg");


        TextView tv_kakaoNickName = findViewById(R.id.tv_kakaoNickName);
        TextView tv_kakaoEmail = findViewById(R.id.tv_kakaoEmail);
        ImageView iv_kakaoImageView = findViewById(R.id.iv_kakaoImageView);

        // 닉네임 set
        tv_kakaoNickName.setText(strNick);
        // 이메일 set
        tv_kakaoEmail.setText(strEmail);
        // 프로필 이미지 사진 set
        Glide.with(KakaoLoginAfter.this).load(strProfileImg).into(iv_kakaoImageView);

        findViewById(R.id.btn_kakaoLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
                    @Override
                    public void onCompleteLogout() {
                        // 로그아웃 성공시 수행하는 지점
                        finish(); // 현재 액티비티 종료
                    }
                });
            }
        });

    }
}