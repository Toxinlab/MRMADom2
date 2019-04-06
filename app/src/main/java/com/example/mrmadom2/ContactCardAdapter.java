package com.example.mrmadom2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ContactCardAdapter extends RecyclerView.Adapter<ContactCardAdapter.ContactCardHolder> {

    private ArrayList<Contact> mDataset;

    public ContactCardAdapter() {
        this.mDataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ContactCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.contactcard_layout,parent,false);
        return new ContactCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactCardHolder holder, int position) {
        Contact contact = mDataset.get(position);
        Picasso.get().load(contact.getPicture()).into(holder.image);
        holder.name.setText(contact.getName());
        holder.surname.setText(contact.getSurname());
        holder.email.setText(contact.getEmail());
        holder.number.setText(contact.getTelephone());
    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setData(ArrayList<Contact> dataset){
        ContactDiffCallback callback = new ContactDiffCallback(mDataset,dataset);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);

        mDataset.clear();
        mDataset.addAll(dataset);

        result.dispatchUpdatesTo(this);

    }

    public class ContactCardHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView surname;
        TextView email;
        TextView number;

        public ContactCardHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.contact_image);
            name = itemView.findViewById(R.id.contact_name);
            surname = itemView.findViewById(R.id.contact_surname);
            number = itemView.findViewById(R.id.contact_number);
            email = itemView.findViewById(R.id.contact_email);
        }
    }
}
