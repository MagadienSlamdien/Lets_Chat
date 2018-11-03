package com.hybridsoftsolutions.letschat.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hybridsoftsolutions.letschat.R;
import com.hybridsoftsolutions.letschat.models.Contact;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Magadien on 2018/08/16.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private List<Contact> contactsList;

    public ContactAdapter() {
    }

    public ContactAdapter(List<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, status;
        CircleImageView photo;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            status = itemView.findViewById(R.id.status);
            photo = itemView.findViewById(R.id.photo);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = contactsList.get(position);
        holder.name.setText(contact.getName());
        holder.status.setText(contact.getStatus());
        //holder.photo.setText(contact.getPhoto());
    }


    @Override
    public int getItemCount() {
        return contactsList.size();
    }
}
