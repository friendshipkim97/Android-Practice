package com.cookandroid.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment4 extends Fragment {

    public Fragment4() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { // 메인클래스에 있는 onCreateView와 같다 액티비티에서 실행되느냐 Fragment에서 실행되느냐의 차이이다.
        return inflater.inflate(R.layout.fragment4, container, false);
    }
}
