package com.hybridsoftsolutions.letschat.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.hybridsoftsolutions.letschat.R;
import com.hybridsoftsolutions.letschat.fragments.CallFragment;
import com.hybridsoftsolutions.letschat.fragments.ChatFragment;
import com.hybridsoftsolutions.letschat.fragments.StatusFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private Menu mOptionsMenu;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        mOptionsMenu = menu;
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.setGroupVisible(R.id.menu_group_chat, true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                new Toast(this).makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_new_group:
                new Toast(this).makeText(this, "New group", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_new_broadcast:
                new Toast(this).makeText(this, "New broadcasr", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_starred_messages:
                new Toast(this).makeText(this, "Starred messages", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_web_app:
                new Toast(this).makeText(this, "Web app", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                new Toast(this).makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.action_chats:
                fragment = new ChatFragment();
                mOptionsMenu.setGroupVisible(R.id.menu_group_chat, true);
                mOptionsMenu.setGroupVisible(R.id.menu_group_status, false);
                break;
            case R.id.action_status:
                fragment = new StatusFragment();
                mOptionsMenu.setGroupVisible(R.id.menu_group_chat, false);
                mOptionsMenu.setGroupVisible(R.id.menu_group_status, true);
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
