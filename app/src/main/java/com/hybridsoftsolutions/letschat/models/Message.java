package com.hybridsoftsolutions.letschat.models;

import org.w3c.dom.Text;

public class Message {
    private String message, user, created;

    public Message() {
    }

    public Message(String message, String user, String created) {
        this.message = message;
        this.user = user;
        this.created = created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
