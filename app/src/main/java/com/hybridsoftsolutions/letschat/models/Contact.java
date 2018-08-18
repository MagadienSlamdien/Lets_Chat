package com.hybridsoftsolutions.letschat.models;

import android.os.Parcel;
import android.os.Parcelable;



public class Contact implements Parcelable {
   private String name, status, photo;

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(status);
        dest.writeString(photo);
    }

    public static final Parcelable.Creator<Contact> CREATOR = new
            Parcelable.Creator<Contact>() {
                @Override
                public Contact createFromParcel(Parcel source) {
                    return new Contact(source);
                }

                @Override
                public Contact[] newArray(int size) {
                    return new Contact[0];
                }
            };

    private Contact(Parcel parcel) {
        name = parcel.readString();
        status = parcel.readString();
        photo = parcel.readString();
    }

    public Contact() {
    }

    public Contact(String name, String status, String photo) {
        this.name = name;
        this.status = status;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
