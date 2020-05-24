package dev.olaore.apiconsumption.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int id;

    private int userId;

    private String title;

    @SerializedName("body")
    private String content;

    public Post() {
    }

    public Post(int userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @NonNull
    @Override
    public String toString() {
        return "Id: " + getId()  + "\nUser Id: " + getUserId() + "\nTitle: " + getTitle() + "\nContent: " + getContent();
    }
}
