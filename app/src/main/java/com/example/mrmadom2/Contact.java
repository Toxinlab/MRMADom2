package com.example.mrmadom2;

import android.util.Log;

public class Contact {

    private static String PICTURE_URL = "https://picsum.photos/1080/1920/?image=";
    private String mName;
    private String mSurname;
    private String mPicture;
    private String mTelephone;
    private String mEmail;
    private int mId;


    public Contact(int id, String mName, String mSurname, String mTelephone, String mEmail) {
        this.mName = mName;
        this.mSurname = mSurname;
        this.mTelephone = mTelephone;
        this.mEmail = mEmail;
        this.mPicture = PICTURE_URL+((int)(Math.random()*100));
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSurname() {
        return mSurname;
    }

    public void setSurname(String surname) {
        mSurname = surname;
    }

    public String getPicture() {
        return mPicture;
    }

    public void setPicture(String picture) {
        mPicture = picture;
    }

    public String getTelephone() {
        return mTelephone;
    }

    public void setTelephone(String telephone) {
        mTelephone = telephone;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}
