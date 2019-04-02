package com.hybridsoftsolutions.letschat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.hybridsoftsolutions.letschat.R;
import com.hybridsoftsolutions.letschat.adapters.MessageAdapter;
import com.hybridsoftsolutions.letschat.models.Chat;
import com.hybridsoftsolutions.letschat.models.Message;
import com.hybridsoftsolutions.letschat.utils.RecyclerTouchListener;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivity extends AppCompatActivity {
    private List<Message> messageList = new ArrayList<>();
    private RecyclerView rv_messages;
    private MessageAdapter mAdapter;
    private EditText mEdittextMessage;

    private Socket socket;
    private String name;
    private static final String TAG = "ChatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        name = (String) getIntent().getExtras().getString(LoginActivity.NICKNAME);

//        Intent i = getIntent();
//        Chat chat = i.getParcelableExtra("Chat");
//
        mEdittextMessage = findViewById(R.id.edittext_chatbox);
//
        mAdapter = new MessageAdapter(this, messageList);
        rv_messages = findViewById(R.id.rv_messages);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        rv_messages.setLayoutManager(lm);
        rv_messages.setItemAnimator(new DefaultItemAnimator());
        rv_messages.setAdapter(mAdapter);
        rv_messages.addOnItemTouchListener(new RecyclerTouchListener(this, rv_messages, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
//                Intent i = new Intent(getActivity(), ChatActivity.class);
//                i.putExtra("Chat", chatsList.get(position));
//                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {
//                Chat chat = chatsList.get(position);
//                Toast.makeText(getContext(), "long click - Name: " + chat.getName().toString() + ", Last Message: " + chat.getLastMessage().toString(), Toast.LENGTH_LONG).show();
            }
        }));

        getSupportActionBar().setTitle(name);
        getSupportActionBar().setCustomView(R.layout.profile_image);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //prepareData();

        try {
            socket = IO.socket("http://192.243.100.152:8008");
            //socket = IO.socket("http://192.168.8.102:8008");
            Log.d(TAG, "onCreate: socket connect");
            socket.connect();

            socket.emit("join", name);

            socket.on("userjoinedthechat", new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String data = (String) args[0];

                            Toast.makeText(ChatActivity.this, data, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });

            socket.on("message", new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            JSONObject data = (JSONObject) args[0];
                            try {
                                String nickName = data.getString("name");
                                String recMessage = data.getString("message");

                                String receiver = "0";

                                if (nickName.equals(name)) {
                                    receiver = "1";
                                }

                                Message message = new Message(recMessage, receiver, "now");

                                messageList.add(message);

                                mAdapter.notifyDataSetChanged();
                            } catch (JSONException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                }
            });

            socket.on("userdisconnect", new Emitter.Listener() {
                @Override
                public void call(final Object... args) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String data = (String) args[0];

                            Toast.makeText(ChatActivity.this, data, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });

        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        socket.disconnect();
    }

    void prepareData() {
        Message message = new Message("Hi, how are you?", "2", "Blah");
        messageList.add(message);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_menu, menu);
        MenuItem menuMore = menu.findItem(R.id.action_chat_more);
        if (menuMore != null) {
            menuMore.getSubMenu().clearHeader();
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
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
//            case R.id.action_chat_more:
//                new Toast(this).makeText(this, "More", Toast.LENGTH_SHORT).show();
//                break;
        }

        return true;
    }

    public void SendOnClick(View view) {
//        Message message = new Message(mEdittextMessage.getText().toString(), "1", "Blah");
//        messageList.add(message);
//
//        mEdittextMessage.setText("");
//
//        mAdapter.notifyDataSetChanged();

        if (!mEdittextMessage.getText().toString().isEmpty()) {
            socket.emit("messagedetection", name, mEdittextMessage.getText().toString());
            mEdittextMessage.setText("");
        }

    }
}
