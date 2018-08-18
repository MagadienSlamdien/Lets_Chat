package com.hybridsoftsolutions.letschat.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.hybridsoftsolutions.letschat.models.Message;

import java.util.List;

/**
 * Created by Magadien on 2018/08/18.
 */

public class MessageAdapter  {
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    private Context mContext;
    private List<Message> mMessagesList;

    public MessageAdapter(Context context, List<Message> messagesList){
        mContext = context;
        mMessagesList = messagesList;
    }
/*
    @Override
    public int getItemCount() {
        return mMessagesList.size();
    }

    @Override
    public int getItemViewType(int position) {
        //UserMessage message = mMessagesList.get(position);


        return super.getItemViewType(position);
    }*/
}
