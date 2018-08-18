package com.hybridsoftsolutions.letschat.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String title, genre, year;

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(genre);
        dest.writeString(year);
    }

    public static final Parcelable.Creator<Movie> CREATOR = new
            Parcelable.Creator<Movie>() {
                @Override
                public Movie createFromParcel(Parcel source) {
                    return new Movie(source);
                }

                @Override
                public Movie[] newArray(int size) {
                    return new Movie[0];
                }
            };

    private Movie(Parcel parcel) {
        title = parcel.readString();
        genre = parcel.readString();
        year = parcel.readString();
    }

    public Movie() {
    }

    public Movie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
