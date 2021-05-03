package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class FragmentBundleExam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_bundle_exam);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        BundleFragment1 bundleFragment1 = new BundleFragment1();
        transaction.replace(R.id.bundleframeLayout, bundleFragment1);
        transaction.commit(); // 저장

    }
}