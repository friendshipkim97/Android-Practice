package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewExample extends AppCompatActivity {

    private VideoView videoView; // 비디오를 실행할 수 있게 도와주는 뷰
    private MediaController mediaController; // 재생이나 정지버튼, 등등과 같은 미디어 제어 버튼부를 담당
    private String videoURL = "https://www.radiantmediaplayer.com/media/bbb-360p.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 화면이 첫 실행이 됐을 때 이것을 수행한다.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view_example);

        videoView = findViewById(R.id.videoView2);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse(videoURL);
        videoView.setMediaController(mediaController); // 미디어 제어 버튼부 세팅
        videoView.setVideoURI(uri); // 비디오 뷰의 주소를 설정
        videoView.start(); // 비디오 실행
    }
}
