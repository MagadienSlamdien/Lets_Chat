package com.hybridsoftsolutions.letschat.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.hybridsoftsolutions.letschat.R;
import com.hybridsoftsolutions.letschat.fragments.CallFragment;
import com.hybridsoftsolutions.letschat.fragments.ChatFragment;
import com.hybridsoftsolutions.letschat.fragments.StatusFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new ChatFragment());


        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.action_chats:
                fragment = new ChatFragment();
                break;
            case R.id.action_status:
                fragment = new StatusFragment();
                break;
            case R.id.action_call:
                fragment = new CallFragment();
                break;
        }
        item.setChecked(true);

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
        return false;
    }

}
