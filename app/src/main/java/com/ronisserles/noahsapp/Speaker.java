package com.ronisserles.noahsapp;

/**
 * Created by Tardis on 6/10/16.
 */
public class Speaker {

    private int id;
    private String name;
    private double age;
    private String imgUri;

    public Speaker(int id, String name, double age, String imgUri) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.imgUri = imgUri;
    }

    public Speaker(String name, double age, String imgUri) {
        this.name = name;
        this.age = age;
        this.imgUri = imgUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
