package com.example.mrmadom2;

import java.util.ArrayList;

import androidx.recyclerview.widget.DiffUtil;

public class ContactDiffCallback extends DiffUtil.Callback {

    private ArrayList<Contact> mOldList;
    private ArrayList<Contact> mNewList;

    public ContactDiffCallback(ArrayList<Contact> oldList, ArrayList<Contact> newList) {
        mOldList = oldList;
        mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Contact oldContact = mOldList.get(oldItemPosition);
        Contact newContact = mNewList.get(newItemPosition);
        return oldContact.getId() == newContact.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Contact oldContact = mOldList.get(oldItemPosition);
        Contact newContact = mNewList.get(newItemPosition);
        return oldContact.getName().equals(newContact.getName());
    }
}
