package com.example.kohlsstepup.data.model;

import java.util.ArrayList;

public class PostEvent {

    public final ArrayList<Post> postMessage;

    public PostEvent(ArrayList<Post> postMessage) {
        this.postMessage = postMessage;
    }

    public ArrayList<Post> getPostMessage() {
        return postMessage;
    }
}