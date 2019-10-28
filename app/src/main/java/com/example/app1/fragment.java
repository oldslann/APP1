package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class fragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
        MyPageAdapter pageAdapter=new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);


    }
}
