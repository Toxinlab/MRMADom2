package com.example.mrmadom2;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {

    private ArrayList<Contact> mContacts;
    private MutableLiveData<ArrayList<Contact>> contactLiveData;

    public ContactViewModel() {
        contactLiveData = new MutableLiveData<>();
        mContacts = new ArrayList<>();

        for (int i = 0; i <= 25; i++){
            mContacts.add(new Contact(Util.generateId(),"Boban " + i, "Gazimuda " + i+0+i, "032124"+i+"00","mud@o.va"));
        }
        contactLiveData.setValue(new ArrayList<>(mContacts));
    }

    public LiveData<ArrayList<Contact>> getContacts(){
        return contactLiveData;
    }

    public void setContacts(ArrayList<Contact> contacts){
        this.contactLiveData.setValue(new ArrayList<Contact>(contacts));
    }

    public void filterContacts(String filterString){
        ArrayList<Contact> tempContacts = new ArrayList<>();
        for (int i = 0; i<mContacts.size();i++) {
            if(mContacts.get(i).getName().startsWith(filterString)){
                tempContacts.add(mContacts.get(i));
            }
        }
        setContacts(tempContacts);
    }
}
