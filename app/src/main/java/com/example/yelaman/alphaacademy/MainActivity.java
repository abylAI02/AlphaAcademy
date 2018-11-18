package com.example.yelaman.alphaacademy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
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
                    Fragment fragment = new TestFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_news:
                    setTitle("News");
                    NewsFragment newsFragment = new NewsFragment();
                    loadFragment(newsFragment);
                    return true;
                case R.id.navigation_user:
                    setTitle("My Account");
                    UserFragment userFragment = new UserFragment();
                    loadFragment(userFragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        android.support.v4.app.FragmentTransaction testFragmentTransaction = getSupportFragmentManager().beginTransaction();
        testFragmentTransaction.replace(R.id.frame, fragment, "ChatFragment");
        testFragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setTitle("Test");
        TestFragment testFragment = new TestFragment();
        loadFragment(testFragment);
    }

}
