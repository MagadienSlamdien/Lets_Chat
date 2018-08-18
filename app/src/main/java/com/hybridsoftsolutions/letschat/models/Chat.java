package com.hybridsoftsolutions.letschat.models;

import android.os.Parcel;
import android.os.Parcelable;


public class Chat implements Parcelable {
   private String name, lastMessage, datetime, profileImage;


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastMessage);
        dest.writeString(datetime);
        dest.writeString(profileImage);
    }

    public Chat(Parcel parcel) {
        name = parcel.readString();
        lastMessage = parcel.readString();
        datetime = parcel.readString();
        profileImage = parcel.readString();
    }

    public static final Parcelable.Creator<Chat> CREATOR = new
            Parcelable.Creator<Chat>() {
                @Override
                public Chat createFromParcel(Parcel source) {
                    return new Chat(source);
                }

                @Override
                public Chat[] newArray(int size) {
                    return new Chat[0];
                }
            };

    @Override
    public int describeContents() {
        return hashCode();
    }

    public Chat() {
    }

    public Chat(String name, String lastMessage, String datetime, String profileImage) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.datetime = datetime;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
