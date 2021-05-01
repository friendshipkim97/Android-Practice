package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cookandroid.myapplication.databinding.ActivityViewBindingExamBinding;

public class ViewBindingExam extends AppCompatActivity {

    private ActivityViewBindingExamBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_binding_exam);
        // 액티비티 바인딩 객체에 할당 및 뷰 설정
        mBinding = ActivityViewBindingExamBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);

        mBinding.tvHelloBinding.setText("정우 안녕하세요 !");
        mBinding.btnHelloBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewBindingExam.this, "안녕하세요 바인딩!", Toast.LENGTH_SHORT).show();
            }
        });

        // 프래그먼트 교체
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameBinding, new BindingFragment());
        ft.commit();
    }
}