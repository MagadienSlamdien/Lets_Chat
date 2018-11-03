package com.hybridsoftsolutions.letschat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.hybridsoftsolutions.letschat.R;
import com.hybridsoftsolutions.letschat.models.Chat;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent i = getIntent();
        Chat chat = i.getParcelableExtra("Chat");
        getSupportActionBar().setTitle(chat.getName());
        getSupportActionBar().setCustomView(R.layout.profile_image);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return false;
    }
}
