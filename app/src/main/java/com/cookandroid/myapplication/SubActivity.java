package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView tv_sub;
    public Button navigateMoveBtn;

    private WebView webView;
    private String url = "https://www.naver.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        init();
        navigateMove();

        Intent intent = getIntent(); // 어디서 날라오는 데이터 값이 있으면 이걸로 받는다.
        String str = intent.getStringExtra("str"); // 데이터를 보낼때와 받는 이름이 같아야 한다.
        tv_sub.setText(str);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url); // url을 트는 메서드
        webView.setWebChromeClient(new WebChromeClient()); // 구글 크롬브라우저에 최적화
        webView.setWebViewClient(new WebViewClientClass());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {     // 뒤로가기를 눌렀을 때
           webView.goBack(); // 뒤로 가는 메서드
           return true;
         }
        return super.onKeyDown(keyCode, event);
    }

    private void init(){
        tv_sub = findViewById(R.id.tv_sub);
        navigateMoveBtn = findViewById(R.id.navigateMoveBtn);
        webView = (WebView)findViewById(R.id.web_View);
    }

    private void navigateMove() {
        navigateMoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this, NavigateMenu.class);
                startActivity(intent);
            }
        });
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

//    private void buttonMove() {
//        btn_move.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, SubActivity.class);
//                str = et_test.getText().toString();
//                intent.putExtra("str", str);
//                startActivity(intent); // 액티비티 이동
//            }
//        });
//    }
}
