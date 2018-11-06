package com.hybridsoftsolutions.letschat.adapters;

import android.content.Context;

import com.hybridsoftsolutions.letschat.models.Message;

import java.util.List;

/**
 * Created by Magadien on 2018/08/18.
 */

public class MessageAdapter  {
    //https://gist.github.com/alkjez/551eabf861b2fd8cc929dc4c34f52f10#file-messagelistadapter2-java
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    private Context mContext;
    private List<Message> mMessagesList;

    public MessageAdapter(Context context, List<Message> messagesList){
        mContext = context;
        mMessagesList = messagesList;
    }

//    @Override
//    public int getItemCount() {
//        return mMessagesList.size();
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        Message message = (Message) mMessagesList.get(position);
//
//        if (message.getUser().equals(1)) {
//            // If the current user is the sender of the message
//            return VIEW_TYPE_MESSAGE_SENT;
//        } else {
//            // If some other user sent the message
//            return VIEW_TYPE_MESSAGE_RECEIVED;
//        }
//    }
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
