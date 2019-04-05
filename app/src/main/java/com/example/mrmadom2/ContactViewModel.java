package com.example.mrmadom2;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Contact>> contactLiveData;

    public ContactViewModel() {
        contactLiveData = new MutableLiveData<>();
        ArrayList<Contact> contacts = new ArrayList<>();

        for (int i = 0; i <= 25; i++){
            contacts.add(new Contact("Boban " + i, "Gazimuda " + i+0+i, "032124"+i+"00","mud@o.va"));
            Log.d("HEJ", "contact");
        }
    }

    public LiveData<ArrayList<Contact>> getContacts(){
        return contactLiveData;
    }

    public void setContacts(ArrayList<Contact> contacts){
        this.contactLiveData.setValue(new ArrayList<Contact>(contacts));
    }
}
