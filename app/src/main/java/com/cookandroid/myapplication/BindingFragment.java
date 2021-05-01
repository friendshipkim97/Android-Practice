package com.cookandroid.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.myapplication.databinding.ActivityFrameFragmentBinding;

public class BindingFragment extends Fragment{

    private ActivityFrameFragmentBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = ActivityFrameFragmentBinding.inflate(getLayoutInflater(), container, false);
        mBinding.btnBindingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.tvBindingView.setText("정우 프래그먼트 클릭 완료");
            }
        });
        return mBinding.getRoot();
    }
}
