package com.hybridsoftsolutions.letschat.models;

import org.w3c.dom.Text;

public class Message {
    private Text message, user, created;

    public Message() {
    }

    public Message(Text message, Text user, Text created) {
        this.message = message;
        this.user = user;
        this.created = created;
    }

    public Text getMessage() {
        return message;
    }

    public void setMessage(Text message) {
        this.message = message;
    }

    public Text getUser() {
        return user;
    }

    public void setUser(Text user) {
        this.user = user;
    }

    public Text getCreated() {
        return created;
    }

    public void setCreated(Text created) {
        this.created = created;
    }
}
