package com.example.mdrop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.mdrop.activities.screenItem;
import com.example.mdrop.adapters.WalkthroughAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SplashscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Thread spalshscreen=new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
                    startActivity(new Intent(getApplicationContext(),WalkThroughActivity.class));
                    finish();

                }catch (Exception e){e.printStackTrace();}
            }
        };
        spalshscreen.start();
    }
}