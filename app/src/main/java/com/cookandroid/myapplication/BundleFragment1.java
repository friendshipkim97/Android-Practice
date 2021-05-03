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

public class BundleFragment1 extends Fragment {

    private View view;
    private TextView bundleText1;
    private Button btn_bundleFragmentMove;
    private String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bundlefragment_1, container, false);

        bundleText1 = view.findViewById(R.id.bundleText1);
        btn_bundleFragmentMove = view.findViewById(R.id.btn_bundleFragmentMove);

        if(getArguments() != null ) { // null : 빈 값
            result = getArguments().getString("fromFrag2"); // 프래그먼트1에서 받아온 데이터
            bundleText1.setText(result);

        }

        btn_bundleFragmentMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle(); // 무언가를 담을 준비를 할 수 있는 보따리
                bundle.putString("fromFrag1", "정우 프래그먼트 1");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                BundleFragment2 bundleFragment2 = new BundleFragment2();
                bundleFragment2.setArguments(bundle);
                transaction.replace(R.id.bundleframeLayout, bundleFragment2);
                transaction.commit(); // 저장

            }
        });

        return view;
    }
}
