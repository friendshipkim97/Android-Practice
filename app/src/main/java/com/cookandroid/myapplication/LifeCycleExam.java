package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LifeCycleExam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Activity가 생성이 될때 어떠한 행동을 해줄것이냐를 적어주는 것
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_exam); // r은 res폴더를 의미한다.
        // 액티비티 또는 프레그먼트가 생성 되었을 때 이곳 내부 구문들을 실행한다.
        Log.e("onCreate", "ENTER");

        findViewById(R.id.btn_lifeCycleTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LifeCycleExam.this, LifeCycleSubExam.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "ENTER");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 중지 되어있던 액티비티가 다시 재개(재 실행) 되는 시점에서 이곳 내부구문들을 실행 ( ex) a -> b 액티비티로갔다가 b 액티비티가 소멸되었을 때 실행)
        Log.e("onResume", "ENTER");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 중지 상태(홈 버튼을 눌러서 바깥으로 잠깐 빠져나갔을 때(앱을 종료한게 아님), 다른 액티비티가 활성화 되어있을 때(안드로이드는 한 화면밖에 띄울 수 없다.)일 때 이곳 내부구문들을 실행
        Log.e("onPause", "ENTER");
    }

    @Override
    protected void onStop() { // 기존 액티비티가 안보이는 상태(투명하게라도 보이면 호출되지 않음)까지 도달했을 때 onStop이 호출된다. , 런쳐화면 자체도 액티비티이다. 우리가 구현을 안했을 뿐
        super.onStop();
        Log.e("onStop", "ENTER");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "ENTER");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 화면이 파괴되어서 소멸했을 때의 시점 일 때 이곳 내부구문들을 실행
        Log.e("onDestroy", "ENTER");
    }


}