package com.cookandroid.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class VPFragMonday extends Fragment {
    private View view;
    private static VPFragMonday vPFragMonday = null;



    public static VPFragMonday newInstance(){
        if(vPFragMonday == null){
            vPFragMonday = new VPFragMonday();
        }
        Log.e("먼데이객체생성", Integer.toString(vPFragMonday.hashCode()));
        return vPFragMonday;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { // onCreateView는 onCreate후에 화면을 구성할 때 호출되는 부분이다.
        Log.e("onCreateView호출", "먼데이");
        view = inflater.inflate(R.layout.vpfrag_monday, container, false); // 연동완료
        return view;
    }

}
