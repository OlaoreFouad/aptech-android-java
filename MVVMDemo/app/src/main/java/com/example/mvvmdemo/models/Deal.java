package com.example.mvvmdemo.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "deals_table")
public class Deal {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    @ColumnInfo(name = "desc")
    private String description;

    private String animal;

//    @Ignore
    private int amount;

    private long createdOn;

    public Deal() {
        this.createdOn = System.currentTimeMillis();
    }

    @Ignore
    public Deal(String title, String description, String animal, int amount) {
        this.title = title;
        this.description = description;
        this.animal = animal;
        this.amount = amount;

        this.createdOn = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getAnimal() {
        return animal;
    }

    public int getAmount() {
        return amount;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
