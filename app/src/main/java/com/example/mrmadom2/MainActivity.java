package com.example.mrmadom2;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private ContactCardAdapter mAdapter;
    private ArrayList<Contact> mContacts;
    private ContactViewModel mViewModel;
    private EditText mFilterEditText;
    private EditText mAddEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        mContacts = new ArrayList<>();
        initViews();
        initButtons();
        initRecycler();
    }

    private void initViews(){
        mViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        mViewModel.getContacts().observe(this, new Observer<ArrayList<Contact>>() {
            @Override
            public void onChanged(ArrayList<Contact> contacts) {
                mContacts = new ArrayList<>(contacts);
                mAdapter.setData(mContacts);
            }
        });
    }

    private void initButtons(){

    }

    private void initRecycler(){
        RecyclerView recyclerView = findViewById(R.id.grid_layout_middle);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        mAdapter = new ContactCardAdapter();
        recyclerView.setAdapter(mAdapter);


    }
}
