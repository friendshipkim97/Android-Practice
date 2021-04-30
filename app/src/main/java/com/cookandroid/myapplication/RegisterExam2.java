package com.cookandroid.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterExam2 extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth; // 파이어베이스 인증
    private DatabaseReference mDatabaseRef; // 실시간 데이터베이스
    private EditText et_registerEmail2, et_registerPassword2; // 회원가입 입력필드
    private Button btn_registerButton2; // 회원가입 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_exam2);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("JungWooproject");

        et_registerEmail2 = findViewById(R.id.et_registerEmail2);
        et_registerPassword2 = findViewById(R.id.et_registerPassword2);
        btn_registerButton2 = findViewById(R.id.btn_registerButton2);

        btn_registerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 회원가입 처리 시작
                String strEmail = et_registerEmail2.getText().toString();
                final String strPwd = et_registerPassword2.getText().toString();

                // Firebase Auth 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(RegisterExam2.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                           if(task.isSuccessful()){
                               FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser(); // 현재 로그인 된 유저를 가져옴
                               UserAccount account = new UserAccount();
                               account.setIdToken(firebaseUser.getUid());
                               account.setEmailId(firebaseUser.getEmail());
                               account.setPassword(strPwd);

                               // setValue : database에 insert (삽입)
                               mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                               Toast.makeText(RegisterExam2.this, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                           } else{
                               Toast.makeText(RegisterExam2.this, "회원가입에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                           }
                    }
                });
            }
        });

    }
}