package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    private ViewPager myViewPager;
    private TabLayout mTabLayout;
    private TabsAccessorAdapter tabsAccessorAdapter;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar=(Toolbar) findViewById(R.id.main_page_toolbar);

        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Talk Talk");

        myViewPager=(ViewPager) findViewById(R.id.main_tabs_pager);
        tabsAccessorAdapter=new TabsAccessorAdapter(getSupportFragmentManager());

        myViewPager.setAdapter(tabsAccessorAdapter);

        mTabLayout=(TabLayout) findViewById(R.id.main_tabs);
        mTabLayout.setupWithViewPager(myViewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(currentUser==null)
        {
            sendUserToLoginActivity();
        }
    }

    private void sendUserToLoginActivity() {
        Intent loginIntent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(loginIntent);
    }
}
