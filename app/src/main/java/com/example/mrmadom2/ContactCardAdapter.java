package com.example.mrmadom2;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactCardAdapter extends RecyclerView.Adapter<ContactCardAdapter.ContactCardHolder> {

    private ArrayList<Contact> mDataset;

    public ContactCardAdapter(ArrayList<Contact> mDataset) {
        this.mDataset = mDataset;
    }

    @NonNull
    @Override
    public ContactCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactCardHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public void setData(ArrayList<Contact> dataset){
        mDataset.clear();
        mDataset.addAll(dataset);
        notifyDataSetChanged();
    }

    public class ContactCardHolder extends RecyclerView.ViewHolder{

        public ContactCardHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
