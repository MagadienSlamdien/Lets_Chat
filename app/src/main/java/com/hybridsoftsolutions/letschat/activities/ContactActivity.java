package com.hybridsoftsolutions.letschat.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.hybridsoftsolutions.letschat.R;
import com.hybridsoftsolutions.letschat.adapters.ContactAdapter;
import com.hybridsoftsolutions.letschat.adapters.MoviesAdapter;
import com.hybridsoftsolutions.letschat.models.Contact;
import com.hybridsoftsolutions.letschat.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    private List<Contact> contactList = new ArrayList<>();
    private RecyclerView rv;
    private ContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        getSupportActionBar().setTitle("Select contact");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rv = findViewById(R.id.recycler_view);

        mAdapter = new ContactAdapter(contactList);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(lm);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rv.setAdapter(mAdapter);

        prepareContactData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void prepareContactData(){

        for (int i = 0; i < 30; i++){
            Contact contact = new Contact("Contact " + i, "Status " + i, "Photo " + i);
            contactList.add(contact);
        }

        mAdapter.notifyDataSetChanged();
    }
}
