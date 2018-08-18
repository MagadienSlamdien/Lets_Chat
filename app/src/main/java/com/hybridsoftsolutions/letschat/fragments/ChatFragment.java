package com.hybridsoftsolutions.letschat.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hybridsoftsolutions.letschat.R;
import com.hybridsoftsolutions.letschat.activities.ChatActivity;
import com.hybridsoftsolutions.letschat.activities.ContactActivity;
import com.hybridsoftsolutions.letschat.adapters.ChatAdapter;
import com.hybridsoftsolutions.letschat.models.Chat;
import com.hybridsoftsolutions.letschat.utils.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magadien on 2018/08/16.
 */

public class ChatFragment extends Fragment implements FloatingActionButton.OnClickListener {
    private List<Chat> chatsList = new ArrayList<>();
    private RecyclerView rv_frag_chat;
    private ChatAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat, null);
        FloatingActionButton fab = v.findViewById(R.id.fab_chat);
        fab.setOnClickListener(this);
        mAdapter = new ChatAdapter(chatsList);
        rv_frag_chat = v.findViewById(R.id.rv_frag_chat);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false);
        rv_frag_chat.setLayoutManager(lm);
        rv_frag_chat.setItemAnimator(new DefaultItemAnimator());
        rv_frag_chat.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        rv_frag_chat.setAdapter(mAdapter);
        rv_frag_chat.addOnItemTouchListener(new RecyclerTouchListener(getContext(), rv_frag_chat, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent i = new Intent(getActivity(), ChatActivity.class);
                i.putExtra("Chat", chatsList.get(position));
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {
                Chat chat = chatsList.get(position);
                Toast.makeText(getContext(), "long click - Name: " + chat.getName().toString() + ", Last Message: " + chat.getLastMessage().toString(), Toast.LENGTH_LONG).show();
            }
        }));

        prepareChatData();
        return v;
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getActivity(), ContactActivity.class);
        startActivity(i);
    }

    private void prepareChatData() {
        for (int i = 0; i < 3; i++) {
            Chat chat = new Chat("Name " + i, "Message " + i, "date time" + i, "image " + i);
            chatsList.add(chat);

        }

        mAdapter.notifyDataSetChanged();
    }
}
