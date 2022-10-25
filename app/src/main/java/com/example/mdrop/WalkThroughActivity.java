package com.example.mdrop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.example.mdrop.activities.screenItem;
import com.example.mdrop.adapters.WalkthroughAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public  class WalkThroughActivity extends AppCompatActivity {
    private ViewPager viewPager2;
    private Button next,getStarted;
    private TabLayout indicator;
    private Animation btn_animation;
    private TextView skip;
    private Context mContext;
    private List<screenItem> screenItemsList;
    private List<String> Titles;
    private List<String> Descriptions;
    private List<Integer> pictures;

    private final String[] titles=new String[]{
            "Welcome to M-Drop",
            "What is M-Drop?",
            "Our goal?"};

    private final String[] descriptions=new String[]{
            "Delivery on a whole new level",
            "M-Drop is an app that lets you ",
            "To offer a platform where patrol officers get an automated way to perform their activities"};

    private final int[] pictureResources=new int[]{
            R.drawable.illustrator1,
            R.drawable.illustrator2,
            R.drawable.illustrator3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_through);
        initializeVariables();

        //checkIfActivityWasOpenedBefore
        if(restorePreviousPref()){startActivity(new Intent(getApplicationContext(),ServiceActivity.class));}

        //Main workflow
        setListeners();
        initializeSliders();
        setUpAdapter(screenItemsList);
        // setUpAnimations();
        setUpPager();
    }
    //initializations
    private void initializeVariables() {
        //set up viewpager
        viewPager2=findViewById(R.id.viewPager);

        //set up button
        next= findViewById(R.id.btn_next_viewPager);
        getStarted= findViewById(R.id.btn_getStarted);

        //textView
        skip= findViewById(R.id.textViewbtn_skipToSignUp);

        //tab
        indicator=findViewById(R.id.tabIndicator);

        mContext=getApplicationContext();

        //initialize ArrayList
        screenItemsList=new ArrayList<>();
        Titles=new ArrayList<>();
        Descriptions=new ArrayList<>();
        pictures=new ArrayList<>();



    }

    private void initializeSliders() {
        for (int index=0;index<titles.length;index++) {
            CreateScreenItem(titles[index], descriptions[index], pictureResources[index]);

            screenItemsList.add(AddScreenItem(index));
        }

    }
    //listeners
    private void setListeners() {

        getStarted.setOnClickListener(view -> viewSignupPage());

        //skip screens
        skip.setOnClickListener(view -> viewSignupPage());

        next.setOnClickListener(view -> displayNextSlide());

        indicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==screenItemsList.size()-1){
                    loadLastScreen();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    //user interface
    private void displayNextSlide() {
        int position = viewPager2.getCurrentItem();
        if (position <screenItemsList.size()){ position++; viewPager2.setCurrentItem(position); }
        if(position ==screenItemsList.size()) loadLastScreen();

    }

    private void loadLastScreen() {
        //views visibility
        getStarted.setVisibility(View.VISIBLE);
        next.setVisibility(View.INVISIBLE);
        indicator.setVisibility(View.INVISIBLE);

        //animation
        // getStarted.setAnimation(btn_animation);

    }
    private void setUpPager() {indicator.setupWithViewPager(viewPager2);}

    //private void setUpAnimations() {btn_animation= AnimationUtils.loadAnimation(mContext,R.anim.btn_getstarted);}

    private void viewSignupPage(){
        //sharedPreferences
        setUpSharedPreferences();

        Intent intent=new Intent(getApplicationContext(), ServiceActivity.class);
        //redirect actiity;
        startActivity(intent);
        finish();
        //redirectActivity(WalkthroughScreen.this,SignUpScreen.class);finish();
    }


    //screen item
    private screenItem AddScreenItem(int index){
        return new screenItem(getTitle(index),getDescription(index),getPicture(index));
    }
    private void CreateScreenItem(String title, String description, int picture){
        addTitle(title); addDescription(description); addPicture(picture);
    }

    private void addTitle(String title){ Titles.add(title);}

    private void addDescription(String description){ Descriptions.add(description); }

    private void addPicture(int picture){ pictures.add(picture);}

    private String getTitle(int index){ return Titles.get(index);}

    private String getDescription(int index){ return Descriptions.get(index); }

    private int getPicture(int index){ return pictures.get(index);}




    //adapters

    private void setUpAdapter(List<screenItem> mList) {

        WalkthroughAdapter adapter=new WalkthroughAdapter(mContext,mList);
        viewPager2.setAdapter(adapter);

    }


    //other
    private boolean restorePreviousPref() {
        SharedPreferences preferences=getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        return preferences.getBoolean("isIntroOpened",false);
    }

    private void setUpSharedPreferences() {

        SharedPreferences preferences=getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.apply();

    }
}
