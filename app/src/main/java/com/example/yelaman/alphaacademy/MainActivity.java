package com.example.yelaman.alphaacademy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;

import android.support.v7.app.AlertDialog;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


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

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.dialog_fire_missiles)
                .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(MainActivity.this , LoginActivity.class));
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .create()
                .show();
    }

}

