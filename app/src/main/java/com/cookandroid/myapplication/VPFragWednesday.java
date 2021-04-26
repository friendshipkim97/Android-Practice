package com.cookandroid.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class VPFragWednesday extends Fragment {
    private View view;
    private static VPFragWednesday vPFragWednesday = null;

    public static VPFragWednesday newInstance(){
        if(vPFragWednesday == null){
            vPFragWednesday = new VPFragWednesday();
        }
        Log.e("웬즈데이객체생성", Integer.toString(vPFragWednesday.hashCode()));
        return vPFragWednesday;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("onCreateView호출", "웬즈데이");
        view = inflater.inflate(R.layout.vpfrag_wednesday, container, false); // 연동완료
        return view;
    }
}
