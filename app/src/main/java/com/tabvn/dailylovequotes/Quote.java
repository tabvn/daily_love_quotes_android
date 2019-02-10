package com.tabvn.dailylovequotes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class Quote {
    @PrimaryKey(autoGenerate = false)
    private int id;
    private String title;
    private String description;
    private String image;
    private String url;
    private String category;
    private String color;
    private int created;

    public Quote(int id, String title, String description, String image, String url, String category, String color, int created) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.url = url;
        this.category = category;
        this.color = color;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }

    public String getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    public int getCreated() {
        return created;
    }
}
