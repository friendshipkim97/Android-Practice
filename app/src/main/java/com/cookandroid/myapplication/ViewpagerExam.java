package com.cookandroid.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayoutMediator;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;
import java.util.List;

public class ViewpagerExam extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_exam);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(this);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        viewPager2.setAdapter(viewPagerAdapter);
        final List<String> tabElement = Arrays.asList("Monday", "Tuesday", "Wednesday");
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView = new TextView(getApplicationContext());
                textView.setText(tabElement.get(position));
                tab.setCustomView(textView);}
        }).attach();

    }
}