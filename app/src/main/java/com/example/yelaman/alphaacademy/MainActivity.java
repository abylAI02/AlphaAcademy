package com.example.yelaman.alphaacademy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_test:
                    setTitle("Test");
                    TestFragment testFragment = new TestFragment();
                    android.support.v4.app.FragmentTransaction testFragmentTransaction = getSupportFragmentManager().beginTransaction();
                    testFragmentTransaction.replace(R.id.frame,testFragment , "ChatFragment");
                    testFragmentTransaction.commit();
                    return true;
                case R.id.navigation_news:
                    setTitle("News");
                    NewsFragment newsFragment = new NewsFragment();
                    android.support.v4.app.FragmentTransaction newsFragmentTransaction = getSupportFragmentManager().beginTransaction();
                    newsFragmentTransaction.replace(R.id.frame,newsFragment , "ChatFragment");
                    newsFragmentTransaction.commit();
                    return true;
                case R.id.navigation_user:
                    setTitle("My Account");
                    UserFragment userFragment = new UserFragment();
                    android.support.v4.app.FragmentTransaction userFragmentTransaction = getSupportFragmentManager().beginTransaction();
                    userFragmentTransaction.replace(R.id.frame,userFragment , "ChatFragment");
                    userFragmentTransaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setTitle("Test");
        TestFragment testFragment = new TestFragment();
        android.support.v4.app.FragmentTransaction testFragmentTransaction = getSupportFragmentManager().beginTransaction();
        testFragmentTransaction.replace(R.id.frame,testFragment , "ChatFragment");
        testFragmentTransaction.commit();
    }

}
