package com.app.covid19_riskassesment.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.app.covid19_riskassesment.R;
import com.app.covid19_riskassesment.fragment.FaqFragment;
import com.app.covid19_riskassesment.fragment.GuidelinesFragment;
import com.app.covid19_riskassesment.fragment.ScoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //const

    //var
    Fragment selectedFragment = new ScoreFragment();;

    //widgets
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.page_1:
                        selectedFragment = new ScoreFragment();
                        break;
                    case R.id.page_2:
                        selectedFragment = new FaqFragment();
                        break;
                    case R.id.page_3:
                        selectedFragment = new GuidelinesFragment();
                        break;
                }
                changeFragment();
                return true;

            }
        });

        changeFragment();

    }

    public void changeFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}