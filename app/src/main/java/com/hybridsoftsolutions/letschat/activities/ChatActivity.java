package com.hybridsoftsolutions.letschat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.home:
                finish();
                break;
            case R.id.action_chat_video:
                new Toast(this).makeText(this, "Video chat", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_chat_call:
                new Toast(this).makeText(this, "Call chat", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_chat_view_contact:
                new Toast(this).makeText(this, "View contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_chat_media:
                new Toast(this).makeText(this, "View contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_chat_search:
                new Toast(this).makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_chat_mute_notifications:
                new Toast(this).makeText(this, "Mute notifications", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_chat_wallpaper:
                new Toast(this).makeText(this, "Wallpaper", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_chat_more:
                new Toast(this).makeText(this, "More", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
