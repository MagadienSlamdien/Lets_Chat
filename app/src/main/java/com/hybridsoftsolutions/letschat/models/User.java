package com.hybridsoftsolutions.letschat.models;

public class User {
    String nickname;
    String profileUrl;

    public User() {
    }

    public User(String nickname, String profileUrl) {
        this.nickname = nickname;
        this.profileUrl = profileUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
