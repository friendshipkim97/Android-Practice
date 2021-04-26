package com.cookandroid.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class VPFragTuesday extends Fragment {
    private View view;
    private static VPFragTuesday vPFragTuesday = null;

    public static VPFragTuesday newInstance(){
        if(vPFragTuesday == null){
            vPFragTuesday = new VPFragTuesday();
        }
        Log.e("투즈데이객체생성", Integer.toString(vPFragTuesday.hashCode()));
        return vPFragTuesday;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("onCreateView호출", "투스데이");
        view = inflater.inflate(R.layout.vpfrag_tuesday, container, false); // 연동완료
        return view;
    }
}
