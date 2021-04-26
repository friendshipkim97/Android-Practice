package com.cookandroid.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class VPFragTuesday extends Fragment {
    private View view;

    public static VPFragTuesday newInstance(){
        VPFragTuesday vPFragTuesday = new VPFragTuesday();
        return vPFragTuesday;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.vpfrag_tuesday, container, false); // 연동완료
        return view;
    }
}
