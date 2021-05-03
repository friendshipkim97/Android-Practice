package com.cookandroid.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class BundleFragment2 extends Fragment {

    private View view;
    private TextView bundleText2;
    private Button btn_bundleFragmentMove2;
    private String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bundlefragment_2, container, false);

        bundleText2 = view.findViewById(R.id.btn_bundleFragmentMove2);
        btn_bundleFragmentMove2 = view.findViewById(R.id.btn_bundleFragmentMove2);

        if(getArguments() != null ) { // null : 빈 값
            result = getArguments().getString("fromFrag1"); // 프래그먼트1에서 받아온 데이터
            bundleText2.setText(result);

        }

        btn_bundleFragmentMove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle(); // 무언가를 담을 준비를 할 수 있는 보따리
                bundle.putString("fromFrag2", "정우 프래그먼트 2");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                BundleFragment1 bundleFragment1 = new BundleFragment1();
                bundleFragment1.setArguments(bundle);
                transaction.replace(R.id.bundleframeLayout, bundleFragment1);
                transaction.commit(); // 저장

            }
        });

        return view;
    }
}
