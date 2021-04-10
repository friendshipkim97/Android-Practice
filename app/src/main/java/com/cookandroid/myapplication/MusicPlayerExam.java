package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicPlayerExam extends AppCompatActivity {

    Button btn_play, btn_stop;

    MediaPlayer mediaPlayer;

    // 액티비티가 종료될때.. 이 메서드를 실행함
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){ // 액티비티가 종료될 때 mediaPlayer의 자원을 해제하는 구문
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player_exam);

        btn_play = findViewById(R.id.btn_play);
        btn_stop = findViewById(R.id.btn_stop);

        // 재생버튼 눌렀을때..
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MusicPlayerExam.this, R.raw.acoustic);
                mediaPlayer.start();

            }
        });

        // 정지버튼 눌렀을때
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                      if(mediaPlayer.isPlaying()){   // isPlaying은 현재 음악이 재생중인지 검사하는 메서드이다, 실행중이 아닌데 스탑을 하면 앱이 죽을 수 있음
                          mediaPlayer.stop();
                          mediaPlayer.reset();
                      }
            }
        });


    }
}
