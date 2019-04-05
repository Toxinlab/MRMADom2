package com.example.mrmadom2;

public class Contact {

    private static String PICTURE_URL = "https://picsum.photos/1080/1920/?image=";
    private String mName;
    private String mSurname;
    private String mPicture;
    private String mTelephone;
    private String mEmail;


    public Contact(String mName, String mSurname, String mTelephone, String mEmail) {
        this.mName = mName;
        this.mSurname = mSurname;
        this.mTelephone = mTelephone;
        this.mEmail = mEmail;
        this.mPicture = PICTURE_URL+(Math.random()*100);

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
}
