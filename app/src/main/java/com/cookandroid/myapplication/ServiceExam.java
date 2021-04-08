package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceExam extends AppCompatActivity {

    Button btn_serviceStart, btn_serviceStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_exam);

        btn_serviceStart = (Button)findViewById(R.id.btn_serviceStart);
        btn_serviceStop = (Button)findViewById(R.id.btn_serviceStop);

        // this와 getApplicationContext의 차이
        // Applicaiton context : 어플리케이션 자체와 연동되는 것이므로, 어플리케이션의 life cycle이 지속되는 동안 동일한 객체이다. 즉, 어플리케이션을 종료 후 다시 실행시킬때에만 바뀜
        // this : 액티비티와 연동된 것이므로, 그 액티비티를 파괴시키고 다시 시작시키면 activity context도 바뀐다. (한 개의 어플리케이션 내에는 여러 액티비티를 넣을 수 있다).
        // xxx.this를 사용한다면 액티비티를 사용한다는 것이고 액티비티가 소멸되면 소멸될 수 있음
        //  getApplicationContext()를 쓰면 컨텍스트가 앱이 죽기 전까지 사라지지 않고, XXXActivity.this를 쓰면 액티비티가 사라질 때 컨텍스트도 같이 사라진다는 뜻이다.
        btn_serviceStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startService(new Intent(ServiceExam.this, MusicService.class));
            }
        });

        btn_serviceStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(ServiceExam.this, MusicService.class));
            }
        });

    }
}
