package com.example.mrmadom2;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
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
    private Button mButton;



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

        mFilterEditText = findViewById(R.id.top_edit_text);
        mAddEditText = findViewById(R.id.bottom_edit_text);
        mButton = findViewById(R.id.bottom_button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = mAddEditText.getText().toString();
                mContacts.add(new Contact(Util.generateId(), temp,temp+"ic","23444124", temp+"@ov.a"));
                mAdapter.setData(mContacts);
            }
        });

        mFilterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mViewModel.filterContacts(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    private void initRecycler(){
        RecyclerView recyclerView = findViewById(R.id.grid_layout_middle);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        mAdapter = new ContactCardAdapter();
        recyclerView.setAdapter(mAdapter);


    }
}
