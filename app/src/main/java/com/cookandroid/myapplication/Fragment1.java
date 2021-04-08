package com.cookandroid.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    public Fragment1() {

    }

    // 메인클래스에 있는 onCreateView와 같다 액티비티에서 실행되느냐 Fragment에서 실행되느냐의 차이이다.
    // onCreateView는 onCreate 후에 화면을 구성할 때 호출하는 부분이다.
    // inflate는 부풀게 하다 라는 뜻, inflate를 통해 xml에 표기된 레이아웃을 메모리에 객체화 시킨다, setContentView 함수도 xml을 객체화시키는 inflate 동작이다.
    // 자동으로 생성된 xml이 아닌 user가 추가적으로 만든 xml을 객체화시키기 위해서 inflate 과정이 필요하다.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }
}
