package com.hybridsoftsolutions.letschat.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hybridsoftsolutions.letschat.R;
import com.hybridsoftsolutions.letschat.models.Chat;

import java.util.List;


public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private List<Chat> chatsList;

    public ChatAdapter() {
    }

    public ChatAdapter(List<Chat> chatsList) {
        this.chatsList = chatsList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, lastMessage, datetime, profileImage;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.chat_name);
            lastMessage = itemView.findViewById(R.id.chat_last_message);
            datetime = itemView.findViewById(R.id.chat_datetime);
            profileImage = itemView.findViewById(R.id.chat_photo);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Chat chat = chatsList.get(position);
        holder.name.setText(chat.getName());
        holder.lastMessage.setText(chat.getLastMessage());
        holder.datetime.setText(chat.getDatetime());
        holder.profileImage.setText(chat.getProfileImage());
    }

    @Override
    public int getItemCount() {
        return chatsList.size();
    }
}
