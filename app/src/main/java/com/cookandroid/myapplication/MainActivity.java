package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// 안드로이드 어플리케이션은 Activity, BroadCastReceiver, Content Provider, Service 총 4가지의 부품으로 구성되어 있다.
public class MainActivity extends AppCompatActivity {

    EditText et_id;
//    Button btn_test;
    ImageView test;

    private Button btn_move;
    private EditText et_test;
    private String str;
    private ListView list;
     EditText et_save;
     String shared = "file";

    private SwitchCompat sc_save;
    private String sharedSwitch;
    private Button custom_move;
    private Button camera_move;
    private Button recyclerView_move;
    private Button fragment_move;
    private Button thread_move;
    private Button dialog_move;
    private Button service_move;
    private Button spinner_move;
    private Button musicPlayer_move;
    private Button googleMap_move;
    private Button bottomNavi_move;
    private Button forReuslt_move;
    private Button selector_move;
    private Button registerLogin_move;
    private Button broadcastReceiver_move;
    private Button videoView_move;
    private Button recyclerViewFire_move;
    private Button checkBox_move;
    private Button radioButton_move;
    private Button viewPager_move;
    private Button lifeCycle_move;
    private Button googleLogin_move;
    private Button login2_move;
    private Button ViewBinding_move;
    private Button cardView_move;

    private long backBtnTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Activity가 실행되면 가장 먼저 onCreate 메소드가 호출된다.

        super.onCreate(savedInstanceState); // 상위 클래스의 onCreate 메소드를 먼저 호출하고 오버라이드된 메서드를 처리한다는 뜻이다.
        setContentView(R.layout.activity_main);

        init();

        buttonMove();
        clickImage();
        adapt();
        textSharedPreferences();
        switchSharedPreferences();

//        et_id = findViewById(R.id.et_id);
//        btn_test = findViewById(R.id.btn_test);
//
//        btn_test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                et_id.setText("김정우");
//            }
//        });

//        String jung = "정우";
//        Log.e("MainActivity : ", jung); // Log.e Log.d 활용하기
    }

    @Override
    public void onBackPressed() { // 기존에 한 번 뒤로가기 버튼을 누르면 앱이 꺼졌지만, 이 메서드를 만든 이후로 두번 뒤로가기 눌러야 앱이 종료됨
        long curTime = System.currentTimeMillis(); // 현재시간 밀리세컨드초로 가져옴
        long gapTime = curTime - backBtnTime; // 현재시간에서 백버튼 누른시간을 빼줌

        if(0 <= gapTime && 2000 >= gapTime){
            super.onBackPressed(); // 백버튼을 눌렀을 때 뒤로가기 기능이 활성화된다.
        }
        else {
            backBtnTime = curTime;
            Toast.makeText(this, "한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }

    private void switchSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(sharedSwitch, 0);
        Boolean checked = sharedPreferences.getBoolean("kim", false); // 아무 값도 들어있지 않으면 false를 반환한다.
        sc_save.setChecked(checked);
    }

    private void textSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("jung", ""); // 아무 값도 들어 있지 않으면 ""를 반환하는 것
        et_save.setText(value);
    }

    @Override
    protected void onDestroy() { // 앱을 종료를 시켰을 때, 엑티비티를 벗어났을때, onDestroy가 호출된다.
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString(); // 현재 et_save에 써져 있는 값을 가져온다.
        editor.putString("jung", value);
        editor.commit(); // 실제적인 세이브

        SharedPreferences sharedPreferences2 = getSharedPreferences(sharedSwitch, 0);
        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        Boolean checked = sc_save.isChecked();
        editor2.putBoolean("kim", checked);
        editor2.commit(); // 실제적인 세이브
    }

    private void adapt() {
        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);
        data.add("정우");
        data.add("안드로이드");
        data.add("사과");
        adapter.notifyDataSetChanged();
    }

    private void init() {
        et_test = findViewById(R.id.et_test);
        btn_move = findViewById(R.id.btn_move);
        list = (ListView)findViewById(R.id.list);
        test = (ImageView)findViewById(R.id.test);
        et_save = (EditText)findViewById(R.id.et_save);
        sc_save =(SwitchCompat)findViewById(R.id.sc_save);
        custom_move = findViewById(R.id.custom_move);
        camera_move = findViewById(R.id.camera_move);
        recyclerView_move = findViewById(R.id.recyclerView_move);
        fragment_move = findViewById(R.id.fragment_move);
        thread_move = findViewById(R.id.thread_move);
        dialog_move = findViewById(R.id.dialog_move);
        service_move = findViewById(R.id.service_move);
        spinner_move = findViewById(R.id.spinner_move);
        musicPlayer_move = findViewById(R.id.musicPlayer_move);
        googleMap_move = findViewById(R.id.googleMap_move);
        bottomNavi_move = findViewById(R.id.bottomNavi_move);
        forReuslt_move = findViewById(R.id.forResult_move);
        selector_move = findViewById(R.id.selector_move);
        registerLogin_move = findViewById(R.id.registerLogin_move);
        broadcastReceiver_move = findViewById(R.id.broadcastReceiver_move);
        videoView_move = findViewById(R.id.videoView_move);
        recyclerViewFire_move = findViewById(R.id.recyclerViewFire_move);
        checkBox_move = findViewById(R.id.checkBox_move);
        radioButton_move = findViewById(R.id.radioButton_move);
        viewPager_move = findViewById(R.id.viewPager_move);
        lifeCycle_move = findViewById(R.id.lifeCycle_move);
        googleLogin_move = findViewById(R.id.googleLogin_move);
        login2_move= findViewById(R.id.login2_move);
        ViewBinding_move = findViewById(R.id.ViewBinding_move);
        cardView_move = findViewById(R.id.cardView_move);
    }

    private void buttonMove() {
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent intent = new Intent(MainActivity.this, SubActivity.class);
                  str = et_test.getText().toString();
                  intent.putExtra("str", str);
                  startActivity(intent); // 액티비티 이동
            }
        });

        custom_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavigateMenuCustom.class);
                startActivity(intent); // 액티비티 이동
            }
        });

        camera_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Camera.class);
                startActivity(intent); // 액티비티 이동
            }
        });

        recyclerView_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyRecyclerView.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        fragment_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Fragment.class);
                startActivity(intent); // 액티비티 이동
            }
        });

        thread_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThreadExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        service_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ServiceExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        dialog_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        spinner_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SpinnerExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        musicPlayer_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MusicPlayerExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        googleMap_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GoogleMapExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        bottomNavi_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BottomNaviExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        forReuslt_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StartActivityForResultExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        selector_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectorExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        registerLogin_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        broadcastReceiver_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BroadCastReceiverExample.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        videoView_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VideoViewExample.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        recyclerViewFire_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FirebaseListExample.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        checkBox_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CheckBoxExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        radioButton_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RadioButtonExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        viewPager_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewpagerExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        lifeCycle_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LifeCycleExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        googleLogin_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GoogleLoginExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        login2_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginExam2.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        ViewBinding_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewBindingExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
        cardView_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardViewExam.class);
                startActivity(intent); // 액티비티 이동
            }
        });
    }

    private void clickImage() {
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "김정우짱", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
